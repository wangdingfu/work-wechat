package com.wdf;

import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.RuntimeUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.wdf.dto.addressbook.UserId;
import com.wdf.dto.checkin.ScheduleData;
import com.wdf.dto.tool.CalendarData;
import com.wdf.dto.tool.DialRecord;
import com.wdf.dto.tool.ReminderData;
import com.wdf.dto.wedrive.AuthItem;
import com.wdf.dto.wedrive.SpaceInfo;
import com.wdf.response.tool.AddScheduleResponse;
import com.wdf.response.tool.CalendarResponse;
import com.wdf.response.tool.GetCalendarResponse;
import com.github.shuaidd.response.wedrive.*;
import com.wdf.response.wedrive.*;
import com.wdf.resquest.oa.CalendarRequest;
import com.wdf.resquest.tool.DialRecordRequest;
import com.wdf.resquest.tool.GetCalendarRequest;
import com.wdf.resquest.tool.ScheduleRequest;
import com.github.shuaidd.resquest.wedrive.*;
import com.wdf.resquest.wedrive.*;
import com.wdf.service.EfficiencyToolService;
import com.google.common.collect.Lists;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;

/**
 * 描述 效率工具
 *
 * @author ddshuai
 * date 2021-01-14 10:10
 **/
public class EfficiencyToolTest extends AbstractTest {

    private EfficiencyToolService toolService;

    /**
     * 日程 应用别名
     */
    public static final String APP_NAME = "schedule";

    /*公费电话应用*/
    public static final String PUBLIC_TELEPHONE = "public-telephone";

    /*微盘*/
    public static final String MICRO_DISK = "micro-disk";

    public static final String USER_ID = "20170410022717";

    @BeforeEach
    public void init() {
        toolService = weChatManager.efficiencyTool();
    }

    /**
     * wcCRbQBwAA3tCVTMpnmDlbKWS-I2nRVQ
     */
    @Test
    public void addCalendar() {
        CalendarRequest request = new CalendarRequest();
        CalendarData calendarData = new CalendarData();
        calendarData.setDescription("测试日程");
        calendarData.setReadonly(1);
        calendarData.setOrganizer(USER_ID);
        calendarData.setSummary("明天开会");
        calendarData.setColor("#0000FF");
        request.setCalendar(calendarData);
        CalendarResponse response = toolService.addCalendar(request, APP_NAME);
        logger.info("{}", response);
    }

    @Test
    public void updateCalendar() {
        CalendarRequest request = new CalendarRequest();
        CalendarData calendarData = new CalendarData();
        calendarData.setCalId("wcCRbQBwAA3tCVTMpnmDlbKWS-I2nRVQ");
        calendarData.setDescription("测试日程-1");
        calendarData.setReadonly(1);
        calendarData.setOrganizer(USER_ID);
        calendarData.setSummary("明天开会咯");
        calendarData.setColor("#0000FF");
        request.setCalendar(calendarData);
        toolService.updateCalendar(request, APP_NAME);
    }

    @Test
    public void getCalendar() {
        GetCalendarRequest request = new GetCalendarRequest();
        request.setCalIdList(Collections.singletonList("wcCRbQBwAA3tCVTMpnmDlbKWS-I2nRVQ"));
        GetCalendarResponse response = toolService.getCalendar(request, APP_NAME);
        logger.info("{}", response);
    }

    /**
     * 40d6a94c5d907efeeaae19fce3b450d5
     *
     * @throws ParseException
     */
    @Test
    public void addSchedule() throws ParseException {
        ScheduleRequest request = new ScheduleRequest();

        ScheduleData scheduleData = new ScheduleData();
        scheduleData.setOrganizer(USER_ID);
        scheduleData.setCalId("wcCRbQBwAA3tCVTMpnmDlbKWS-I2nRVQ");
        scheduleData.setStartTime(DateUtils.parseDate("2021-01-15 12:00:00", "yyyy-MM-dd HH:mm:ss"));
        scheduleData.setEndTime(DateUtils.parseDate("2021-01-15 14:00:00", "yyyy-MM-dd HH:mm:ss"));
        scheduleData.setSummary("需求评审会议");
        scheduleData.setDescription("2.0版本需求初步评审");
        scheduleData.setLocation("广州国际媒体港10楼1005会议室");

        ReminderData reminderData = new ReminderData();
        reminderData.setIsRemind(1);
        scheduleData.setReminders(reminderData);

        UserId userId = new UserId();
        userId.setUserId("SiGuangMeng");
        scheduleData.setAttendees(Collections.singletonList(userId));

        request.setSchedule(scheduleData);
        AddScheduleResponse scheduleResponse = toolService.addSchedule(request, APP_NAME);
        logger.info("{}", scheduleResponse);
    }

    @Test
    public void getDialRecord() {
        DialRecordRequest recordRequest = new DialRecordRequest();
        List<DialRecord> dialRecords = toolService.getDialRecord(recordRequest, PUBLIC_TELEPHONE);
        logger.info("获取到的公费电话拨打记录数据--{}", dialRecords);
    }

    /**
     * s.ww36e0a51aab349a7d.6620425469yR
     */
    @Test
    public void createSpace() {
        CreateSpaceRequest request = new CreateSpaceRequest();
        request.setUserId(USER_ID);
        request.setSpaceSubType(0);
        request.setSpaceName("日常支持");
        String spaceId = toolService.createSpace(request, MICRO_DISK);
        logger.info("创建的空间编号--{}", spaceId);
    }

    @Test
    public void renameSpace() {
        RenameSpaceRequest request = new RenameSpaceRequest();
        request.setSpaceId("s.ww36e0a51aab349a7d.6620425469yR");
        request.setSpaceName("产品文档");
        request.setUserId(USER_ID);
        toolService.renameSpace(request, MICRO_DISK);
    }

    @Test
    public void dismissSpace() {
        DismissSpaceRequest request = new DismissSpaceRequest();
        request.setSpaceId("");
        request.setUserId(USER_ID);
        toolService.dismissSpace(request, MICRO_DISK);
    }

    @Test
    public void spaceInfo() {
        SpaceInfoRequest request = new SpaceInfoRequest();
        request.setSpaceId("s.ww36e0a51aab349a7d.6620425469yR");
        request.setUserId(USER_ID);
        SpaceInfo spaceInfo = toolService.spaceInfo(request, MICRO_DISK);
        logger.info("空间信息--{}", spaceInfo);
    }

    @Test
    public void addSpaceAcl() {
        SpaceAclRequest request = new SpaceAclRequest();
        request.setSpaceId("s.ww36e0a51aab349a7d.6620425469yR");
        request.setUserId(USER_ID);

        AuthItem spaceAuthItem = new AuthItem();
        spaceAuthItem.setAuth(1);
        spaceAuthItem.setType(1);
        spaceAuthItem.setUserId("20170516024090");

        request.setAuthInfo(Collections.singletonList(spaceAuthItem));
        toolService.addSpaceAcl(request, MICRO_DISK);
    }

    @Test
    public void delSpaceAcl() {
        SpaceAclRequest request = new SpaceAclRequest();
        request.setSpaceId("s.ww36e0a51aab349a7d.6620425469yR");
        request.setUserId(USER_ID);
        AuthItem spaceAuthItem = new AuthItem();
        spaceAuthItem.setType(1);
        spaceAuthItem.setUserId("20170516024090");
        toolService.delSpaceAcl(request, MICRO_DISK);
    }

    @Test
    public void spaceSetting() {
        SpaceSettingRequest request = new SpaceSettingRequest();
        request.setSpaceId("s.ww36e0a51aab349a7d.6620425469yR");
        request.setUserId(USER_ID);
        request.setEnableWatermark(false);
        toolService.spaceSetting(request, MICRO_DISK);
    }

    @Test
    public void spaceShare() {
        CommonSpaceRequest request = new CommonSpaceRequest();
        request.setSpaceId("s.ww36e0a51aab349a7d.6620425469yR");
        request.setUserId(USER_ID);
        String url = toolService.spaceShare(request, MICRO_DISK);
        logger.info("分享链接--{}", url);
    }

    /**
     * todo userid not found
     */
    @Test
    public void listFile() {
        QueryFileRequest request = new QueryFileRequest();
        request.setFatherId("s.ww36e0a51aab349a7d.6620425469yR");
        request.setSpaceId("s.ww36e0a51aab349a7d.6620425469yR");
        request.setUserId(USER_ID);
        request.setSortType(1);
        request.setLimit(100);
        request.setStart(0);

        SpaceFileResponse response = toolService.listFile(request, MICRO_DISK);
        logger.info("文件列表--{}", response);
    }

    /**
     * s.ww36e0a51aab349a7d.6620425469yR_d.6621109333Btp
     */
    @Test
    public void createFile() {
        CreateFileRequest request = new CreateFileRequest();
        request.setFileName("日常支持");
        request.setFileType(1);
        request.setFatherId("s.ww36e0a51aab349a7d.6620425469yR");
        request.setSpaceId("s.ww36e0a51aab349a7d.6620425469yR");
        request.setUserId(USER_ID);
        CreateFileResponse response = toolService.createFile(request, MICRO_DISK);
        logger.info("创建成功--{}", response);
    }

    /**
     * s.ww36e0a51aab349a7d.6620425469yR_f.662112027qfyY
     *
     * @throws Exception e
     */
    @Test
    public void uploadFile() throws Exception {
        File file = ResourceUtils.getFile("classpath:image/20659972.png");
        String fileContent = Base64.encodeBase64String(IOUtils.toByteArray(new FileInputStream(file)));
        UploadFileRequest request = new UploadFileRequest();
        request.setFileName("20659972.png");
        request.setFatherId("s.ww36e0a51aab349a7d.6620425469yR_d.6621109333Btp");
        request.setSpaceId("s.ww36e0a51aab349a7d.6620425469yR");
        request.setUserId(USER_ID);
        request.setFileBase64Content(fileContent);
        CreateFileResponse response = toolService.uploadFile(request, MICRO_DISK);
        logger.info("创建成功--{}", response);
    }

    @Test
    public void downloadFile() throws Exception {
        DownloadFileRequest request = new DownloadFileRequest();
        request.setFileId("s.ww36e0a51aab349a7d.6620425469yR_f.662112027qfyY");
        request.setUserId(USER_ID);
        DownloadFileResponse response = toolService.downloadFile(request, MICRO_DISK);
        logger.info("下载成功--{}", response);

        /*简单的下载到本地*/
        File file = ResourceUtils.getFile("classpath:download/20659972.png");
        HttpHeaders headers = new HttpHeaders();
        headers.set("Cookie", response.getCookieName() + "=" + response.getCookieValue());
        HttpEntity<?> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<byte[]> responseEntity = restTemplate.exchange(response.getDownloadUrl(), HttpMethod.GET, entity, byte[].class);
        IOUtils.write(responseEntity.getBody(), new FileOutputStream(file));
    }

    @Test
    public void renameFile() {
        RenameFileRequest request = new RenameFileRequest();
        request.setUserId(USER_ID);
        request.setFileId("s.ww36e0a51aab349a7d.6620425469yR_f.662112027qfyY");
        request.setNewName("头像.png");

        RenameFileResponse response = toolService.renameFile(request, MICRO_DISK);
        logger.info("操作成功--{}", response);
    }

    @Test
    public void moveFile() {
        MoveFileRequest request = new MoveFileRequest();
        request.setUserId(USER_ID);
        request.setFileId(Collections.singletonList("s.ww36e0a51aab349a7d.6620425469yR_f.662112027qfyY"));
        request.setFatherId("s.ww36e0a51aab349a7d.6620425469yR");
        request.setReplace(false);
        MoveFileResponse response = toolService.moveFile(request, MICRO_DISK);
        logger.info("操作成功--{}", response);
    }

    @Test
    public void deleteFile() {
        DeleteFileRequest request = new DeleteFileRequest();
        request.setUserId(USER_ID);
        request.setFileId(Collections.singletonList("s.ww36e0a51aab349a7d.6620425469yR_f.662112027qfyY"));
        toolService.deleteFile(request, MICRO_DISK);
        logger.info("操作成功");
    }

    @Test
    public void fileInfo() {
        FileInfoRequest request = new FileInfoRequest();
        request.setUserId(USER_ID);
        request.setFileId("s.ww36e0a51aab349a7d.6620425469yR_f.662112027qfyY");
        FileInfoResponse response = toolService.fileInfo(request, MICRO_DISK);
        logger.info("操作成功: {}", response.getFileInfo());
    }

    @Test
    public void addFileAcl() {
        FileAclRequest request = new FileAclRequest();
        request.setUserId(USER_ID);
        request.setFileId("s.ww36e0a51aab349a7d.6620425469yR_f.662157955op7B");

        AuthItem authItem = new AuthItem();
        authItem.setType(1);
        authItem.setAuth(1);
        authItem.setUserId("20170516024090");

        request.setAuthInfo(Collections.singletonList(authItem));
        toolService.addFileAcl(request, MICRO_DISK);
        logger.info("操作成功");
    }

    @Test
    public void delFileAcl() {
        FileAclRequest request = new FileAclRequest();
        request.setUserId(USER_ID);
        request.setFileId("s.ww36e0a51aab349a7d.6620425469yR_f.662157955op7B");

        AuthItem authItem = new AuthItem();
        authItem.setUserId("20170516024090");
        request.setAuthInfo(Collections.singletonList(authItem));
        toolService.delFileAcl(request, MICRO_DISK);
        logger.info("操作成功");
    }

    @Test
    public void fileSetting() {
        FileSettingRequest request = new FileSettingRequest();
        request.setUserId(USER_ID);
        request.setFileId("s.ww36e0a51aab349a7d.6620425469yR_f.662157955op7B");
        request.setAuthScope(2);
        request.setAuth(1);
        toolService.fileSetting(request, MICRO_DISK);
        logger.info("操作成功");
    }

    @Test
    public void getFileShare() {
        FileInfoRequest request = new FileInfoRequest();
        request.setUserId(USER_ID);
        request.setFileId("s.ww36e0a51aab349a7d.6620425469yR_f.662157955op7B");
        FileShareResponse response = toolService.getFileShare(request, MICRO_DISK);
        logger.info("操作成功--{}", response);
    }

    @Test
    public void proInfo() {
        ProInfoRequest request = new ProInfoRequest();
        request.setUserId(USER_ID);
        ProInfoResponse response = toolService.proInfo(request, MICRO_DISK);
        logger.info("操作成功--{}", response);
    }

    @Test
    public void capacity() {
        ProInfoRequest request = new ProInfoRequest();
        request.setUserId(USER_ID);
        CapacityResponse response = toolService.capacity(request, MICRO_DISK);
        logger.info("操作成功--{}", response);
    }

    @Test
    public void calculateSha() throws Exception {
        File file = ResourceUtils.getFile("classpath:image/IMG_20190919_131404.jpg");
        try (FileInputStream inputStream = new FileInputStream(file);) {
            byte[] bytes = new byte[2097152];//2M
            int read;
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            while ((read = inputStream.read(bytes)) > -1) {
                mdTemp.update(bytes, 0, read);
                MessageDigest clone = (MessageDigest) mdTemp.clone();
                logger.info("获取到的sha值--{}", HexUtil.encodeHexStr(clone.digest()));
            }
        }

        String a = DigestUtil.sha1Hex("1");
        logger.info("获取到的sha值--{}", a);
    }

    /**
     * blocks: 2
     * part_num: 1 end_offset: 2097152 cumulate_sha1: 70864d429c1abd1da6b33daf5365cfe47f40fbb6
     * part_num: 2 end_offset: 3902474 cumulate_sha1: ab17bd269fe988af8f2a2ef51c59beadf68e2ac0”
     * <p>
     * 计算sha值
     * ./file-block-digest-mac 文件绝对路径
     * @throws Exception e
     */
    @Test
    public void initUploadFile() throws Exception {
        File file = ResourceUtils.getFile("classpath:image/IMG_20190919_131404.jpg");
        List<String> blockSha = getBlockSha();
        List<String> base64List = Lists.newArrayList();
        try (FileInputStream inputStream = new FileInputStream(file);) {
            byte[] bytes = new byte[2 * 1024 * 1024];//2M

            int byteCnt;
            while ((byteCnt = inputStream.read(bytes)) > 0) {
                if (2097152 - byteCnt > 0) {
                    //结束了
                    byte[] subBytes = new byte[byteCnt];
                    System.arraycopy(bytes, 0, subBytes, 0, byteCnt);
                    base64List.add(Base64.encodeBase64String(subBytes));
                } else {
                    base64List.add(Base64.encodeBase64String(bytes));
                }
            }

            uploadPart(blockSha,inputStream.getChannel().size(),base64List);
        }
    }

    public List<String> getBlockSha() throws IOException {
        // file-block-digest-mac 计算sha值二级制工具 是从官方的 c++ demo 里 编译的
        File digestTool = ResourceUtils.getFile("classpath:file-digest/file-block-digest-mac");
        File uploadFile = ResourceUtils.getFile("classpath:image/IMG_20190919_131404.jpg");
        String cmd = String.format("%s %s",digestTool.getAbsolutePath(),uploadFile.getAbsolutePath());
        String res = RuntimeUtil.execForStr(cmd);
        List<String> blockSha = Lists.newArrayList();
        for (String s : res.split("\n")) {
            if (s.contains("cumulate_sha1:")) {
                blockSha.add(s.split("cumulate_sha1:")[1].trim());
            }
        }

        return blockSha;
    }

    private void uploadPart(List<String> blockSha, Long size, List<String> base64List) {
        InitUploadFileRequest request = new InitUploadFileRequest();
        request.setBlockSha(blockSha);
        request.setFatherId("s.ww36e0a51aab349a7d.6620425469yR");
        request.setUserId(USER_ID);
        request.setFileName("IMG_20190919_131404.jpg");
        request.setSize(size);
        request.setSpaceId("s.ww36e0a51aab349a7d.6620425469yR");
        request.setSkipPushCard(false);
        InitUploadFileResponse response = toolService.initUploadFile(request, MICRO_DISK);
        logger.info("获取到的上传初始化参数---{}", response);
        int i = 1;
        for (String content : base64List) {
            FileUploadPartRequest uploadPartRequest = new FileUploadPartRequest();
            uploadPartRequest.setFileBase64Content(content);
            uploadPartRequest.setIndex(i);
            uploadPartRequest.setUploadKey(response.getUploadKey());
            uploadPartRequest.setUserId(USER_ID);

            //企业微信返回  unknow error  ！！！！！
            toolService.fileUploadPart(uploadPartRequest, MICRO_DISK);
            i++;
        }

        FileUploadFinishRequest finishRequest = new FileUploadFinishRequest();
        finishRequest.setUploadKey(response.getUploadKey());
        finishRequest.setUserId(USER_ID);
        FileUploadFinishResponse finishResponse = toolService.fileUploadFinish(finishRequest, MICRO_DISK);
        logger.info("分块上传完成--{}", finishResponse);
    }

    @Test
    public void mergeFile() throws Exception {
        File file = ResourceUtils.getFile("classpath:upload/temp1");
        File file1 = ResourceUtils.getFile("classpath:upload/temp2");
        File out = new File(file1.getParent() + "/IMG_20190919_131404.jpg");
        try (FileInputStream inputStream = new FileInputStream(file); FileInputStream inputStream1 = new FileInputStream(file1); FileOutputStream outputStream = new FileOutputStream(out)) {
            IOUtils.copy(inputStream, outputStream);
            IOUtils.copy(inputStream1, outputStream);
        }
    }

    @Test
    public void fileUploadPart() {
        FileUploadPartRequest request = new FileUploadPartRequest();
        toolService.fileUploadPart(request, MICRO_DISK);
    }

    @Test
    public void fileUploadFinish() {
        FileUploadFinishRequest request = new FileUploadFinishRequest();
        toolService.fileUploadFinish(request, MICRO_DISK);
    }
}
