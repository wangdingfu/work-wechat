package com.wdf;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wdf.dto.checkin.CheckInData;
import com.wdf.dto.checkin.CheckInRule;
import com.wdf.dto.checkin.SetCheckInScheduleItem;
import com.wdf.dto.oa.ApplyData;
import com.wdf.dto.oa.ApplyDataContent;
import com.wdf.dto.oa.ApproverAttr;
import com.wdf.dto.oa.SummaryInfo;
import com.wdf.dto.oa.formcontrol.*;
import com.wdf.dto.template.TemplateText;
import com.wdf.response.oa.*;
import com.wdf.resquest.JournalReportStatRequest;
import com.wdf.resquest.RequestFilter;
import com.wdf.resquest.kf.PunchCorrectionRequest;
import com.wdf.resquest.oa.*;
import com.google.common.collect.Lists;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;

/**
 * 描述 OA 接口测试用例
 *
 * @author ddshuai
 * date 2021-07-15 09:16
 **/
public class OAServiceTest extends AbstractTest {

    /*打卡应用*/
    public static final String CHECK_IN = "check-in";

    /*审批应用*/
    public static final String APPROVE = "approve";

    /*汇报应用*/
    public static final String REPORT = "report";

    /*会议室应用*/
    public static final String MEETING_ROOM = "meeting-room";

    @Test
    public void getCorpCheckInOption() {
        CheckInOptionResponse checkInOptionResponse = weChatManager.oaService().getCorpCheckInOption(CHECK_IN);
        logger.info("获取到的打卡数据--{}", checkInOptionResponse);
    }


    @Test
    public void getCheckInData() {
        CheckInDataRequest request = new CheckInDataRequest();
        request.setOpenCheckInDataType(3);
        request.setStartTime(getUnixTime("2021-07-15 00:00:00"));
        request.setEndTime(getUnixTime("2021-07-15 23:59:59"));
        request.setUserIdList(Collections.singletonList("20170410022717"));
        List<CheckInData> checkInData = weChatManager.oaService().getCheckInData(request, CHECK_IN);
        logger.info("获取到的打卡数据--{}", checkInData);
    }

    @Test
    public void getCheckInOption() {
        CheckInRuleRequest request = new CheckInRuleRequest();
        request.setUserIdList(Collections.singletonList("20200914034599"));
        request.setDateTime(getUnixTime("2021-07-16 00:00:00"));
        List<CheckInRule> checkInRules = weChatManager.oaService().getCheckInOption(request, CHECK_IN);
        logger.info("获取到的员工打卡规则--{}", checkInRules);
    }

    @Test
    public void getCheckInDayData() {
        CommonOaRequest request = new CommonOaRequest();
        request.setStartTime(getUnixTime("2021-07-15 00:00:00"));
        request.setEndTime(getUnixTime("2021-07-16 00:00:00"));
        request.setUserIdList(Collections.singletonList("20170410022717"));
        CheckInDayReportResponse reportResponse = weChatManager.oaService().getCheckInDayData(request, CHECK_IN);
        logger.info("获取打卡日报数据--{}", reportResponse);
    }

    @Test
    public void getCheckInMonthData() {
        CommonOaRequest request = new CommonOaRequest();
        request.setStartTime(getUnixTime("2021-07-01 00:00:00"));
        request.setEndTime(getUnixTime("2021-07-20 00:00:00"));
        request.setUserIdList(Collections.singletonList("20170410022717"));
        CheckInDayReportResponse reportResponse = weChatManager.oaService().getCheckInMonthData(request, CHECK_IN);
        logger.info("获取打卡月报数据--{}", reportResponse);
    }

    @Test
    public void getCheckInScheduleList() {
        CommonOaRequest request = new CommonOaRequest();
        request.setStartTime(getUnixTime("2021-07-01 00:00:00"));
        request.setEndTime(getUnixTime("2021-07-20 00:00:00"));
        request.setUserIdList(Collections.singletonList("20170410022717"));
        CheckInScheduleResponse reportResponse = weChatManager.oaService().getCheckInScheduleList(request, CHECK_IN);
        logger.info("获取打卡人员排班信息数据--{}", reportResponse);
    }

    /**
     * 需要设置当前时间之后的日期，否则会出现下面的错误
     * day or monthyear error
     */
    @Test
    public void setCheckInScheduleList() {
        SetCheckInScheduleRequest request = new SetCheckInScheduleRequest();
        request.setGroupId(4);
        request.setYearMonth("202107");

        SetCheckInScheduleItem scheduleItem = new SetCheckInScheduleItem();
        scheduleItem.setDay(18);
        scheduleItem.setUserId("20200914034599");
        scheduleItem.setScheduleId(0);

        request.setItems(Collections.singletonList(scheduleItem));
        weChatManager.oaService().setCheckInScheduleList(request, CHECK_IN);
        logger.info("设置排班信息成功");
    }

    @Test
    public void addCheckInUserFace() {
        AddCheckInUserFaceRequest request = new AddCheckInUserFaceRequest();
        request.setUserFace("sdsds");
        request.setUserId("20200914034599");
        weChatManager.oaService().addCheckInUserFace(request, CHECK_IN);
    }

    @Test
    public void getTemplateDetail() {
        TemplateRequest request = new TemplateRequest();
        request.setTemplateId("BsAd7RkLz1aRGJ53jbpnypWcBoHkmsMgqjKVjnSJn");
        ApproveTemplateResponse response = weChatManager.oaService().getTemplateDetail(request, APPROVE);
        logger.info("获取审批模板详情数据--{}", response);
    }

    /**
     * 202107160001
     *
     * @throws JsonProcessingException
     */
    @Test
    public void applyEvent() throws JsonProcessingException {
        ApplyEventRequest request = new ApplyEventRequest();
        request.setCreatorUserId("20200914034599");
        request.setTemplateId("BsAd7RkLz1aRGJ53jbpnypWcBoHkmsMgqjKVjnSJn");
        request.setUseTemplateApprover(0);

        ApproverAttr approverAttr = new ApproverAttr();
        approverAttr.setUserId("20170410022717");
        approverAttr.setAttr("2");
        request.setApproverAttrs(Collections.singletonList(approverAttr));

        ApplyData applyData = new ApplyData();

        ApplyDataContent applyDataContent = new ApplyDataContent();
        applyDataContent.setControl("Money");
        applyDataContent.setId("Money-1626412408973");
        applyDataContent.setValue(new MoneyFormControl("12"));

        ApplyDataContent applyDataContent1 = new ApplyDataContent();
        applyDataContent1.setControl("Vacation");
        applyDataContent1.setId("vacation-1563793073898");

        VacationFormControl vacationFormControl = new VacationFormControl();
        VacationData vacationData = new VacationData();

        Attendance attendance = new Attendance();
        AttendanceDateRange dateRange = new AttendanceDateRange();
        dateRange.setNewBegin(getUnixTime("2021-07-19 09:00:00"));
        dateRange.setNewEnd(getUnixTime("2021-07-19 18:00:00"));
        dateRange.setNewDuration(291600L);
        dateRange.setType("hour");
        attendance.setDateRange(dateRange);
        attendance.setType(1);
        vacationData.setAttendance(attendance);

        SelectorData selector = new SelectorData();
        selector.setType("single");

        SelectorOptionData optionData = new SelectorOptionData();
        optionData.setKey("4");
        optionData.setValue(Collections.singletonList(new TemplateText("调休假", "zh_CN")));
        selector.setOptions(Collections.singletonList(optionData));
        vacationData.setSelector(selector);

        vacationFormControl.setVacation(vacationData);
        applyDataContent1.setValue(vacationFormControl);

        applyData.setContents(Lists.newArrayList(applyDataContent, applyDataContent1));
        request.setApplyData(applyData);

        SummaryInfo summaryInfo = new SummaryInfo();
        TemplateText templateText = new TemplateText();
        templateText.setText("请审批");
        templateText.setLang("zh_CN");
        summaryInfo.setSummaryInfo(Collections.singletonList(templateText));
        request.setSummaryInfos(Collections.singletonList(summaryInfo));

        String rqStr = objectMapper.writeValueAsString(request);
        logger.info("请求的json串---{}", rqStr);
        ApplyEventResponse response = weChatManager.oaService().applyEvent(request, APPROVE);
        logger.info("发起审批的结果--{}", response);
    }

    @Test
    public void getApprovalInfo() {
        GetApprovalNoRequest request = new GetApprovalNoRequest();
        request.setSize(100);
        request.setStartTime(getUnixTime("2021-07-15 00:00:00"));
        request.setEndTime(getUnixTime("2021-07-17 00:00:00"));

        RequestFilter requestFilter = new RequestFilter("sp_status", "2");
        request.setFilters(Collections.singletonList(requestFilter));
        SpNoResponse response = weChatManager.oaService().getApprovalInfo(request, APPROVE);
        logger.info("批量获取审批单号的结果--{}", response);
    }

    @Test
    public void jsonDecodeTest() throws IOException {
        File file = ResourceUtils.getFile("classpath:json/getapprovaldetail.json");
        String result = IOUtils.toString(new FileInputStream(file));
        logger.info("读取到的json内容--{}", result);
        ApprovalDetailResponse approvalDetailResponse = objectMapper.readValue(result, ApprovalDetailResponse.class);
        logger.info("转换后的ApprovalDetailResponse--{}", approvalDetailResponse);
    }

    @Test
    public void getApprovalDetail() {
        ApprovalDetailRequest request = new ApprovalDetailRequest();
        request.setSpNo("202107160001");
        ApprovalDetailResponse response = weChatManager.oaService().getApprovalDetail(request, APPROVE);
        logger.info("获取审批申请详情--{}", response);
    }

    @Test
    public void getCorpConf() {
        VacationConfigResponse response = weChatManager.oaService().getCorpConf(APPROVE);
        logger.info("获取企业假期管理配置--{}", response);
    }

    @Test
    public void getUserVacationQuota() {
        UserIdRequest request = new UserIdRequest();
        request.setUserId("20170410022717");
        UserVacationQuotaResponse response = weChatManager.oaService().getUserVacationQuota(request, APPROVE);
        logger.info("获取成员假期余额--{}", response);
    }

    @Test
    public void setOneUserQuota() {
        UpdateUserQuotaRequest request = new UpdateUserQuotaRequest();
        request.setUserId("20170410022717");
        request.setVacationId(1);
        request.setLeftDuration(3600);
        request.setTimeAttr(1);
        request.setRemarks("ye ye  simida");
        weChatManager.oaService().setOneUserQuota(request, APPROVE);
        logger.info("修改成员假期余额--成功");
    }

    @Test
    public void getJournalRecordList() {
        JournalRecordRequest recordRequest = new JournalRecordRequest();
        recordRequest.setStartTime(getUnixTime("2021-07-14 00:00:00"));
        recordRequest.setEndTime(getUnixTime("2021-07-21 00:00:00"));
        JournalRecordResponse response = weChatManager.oaService().getJournalRecordList(recordRequest, REPORT);
        logger.info("批量获取汇报记录单号--{}", response);
    }

    @Test
    public void getJournalRecordDetail() {
        JournalReportDetailRequest recordRequest = new JournalReportDetailRequest();
        recordRequest.setJournalId("9ZeLBvVm9DJtwdDhkcSThnGtUUrtgzt1eqjffeWNw4uCduzmG2DneWhrisgiKTnLUd");
        JournalReportDetailResponse response = weChatManager.oaService().getJournalRecordDetail(recordRequest, REPORT);
        logger.info("获取汇报记录详情--{}", response);
    }

    @Test
    public void getJournalStatList() {
        JournalReportStatRequest recordRequest = new JournalReportStatRequest();
        recordRequest.setTemplateId("Bs2gafGvr9GhZKa7KiJMU3PGAS2hx5xvK3g6V3Aqd");
        recordRequest.setStartTime(getUnixTime("2021-07-14 00:00:00"));
        recordRequest.setEndTime(getUnixTime("2021-07-21 00:00:00"));
        JournalReportStatResponse response = weChatManager.oaService().getJournalStatList(recordRequest, REPORT);
        logger.info("获取汇报统计数据--{}", response);
    }

    @Test
    public void addMeetingRoom() {
        MeetingRoomRequest request = new MeetingRoomRequest();
        request.setBuilding("聚龙大厦");
        request.setCapacity(10);
        request.setCity("杭州");
        request.setEquipment(Collections.singletonList(1));
        request.setFloor("11F");
        request.setName("西溪路11楼大会议室");
        AddMeetingRoomResponse response = weChatManager.oaService().addMeetingRoom(request, MEETING_ROOM);
        logger.info("添加会议室--{}", response);
    }

    @Test
    public void updateMeetingRoom() {
        MeetingRoomRequest request = new MeetingRoomRequest();
        request.setBuilding("银都大厦");
        request.setCapacity(10);
        request.setCity("杭州");
        request.setEquipment(Collections.singletonList(1));
        request.setFloor("11F");
        request.setName("西溪路11楼大会议室");
        request.setMeetingRoomId("1");
        weChatManager.oaService().updateMeetingRoom(request, MEETING_ROOM);
        logger.info("更新会议室--成功");
    }

    @Test
    public void searchMeetingRoom() {
        MeetingRoomRequest request = new MeetingRoomRequest();
        MeetingRoomListResponse response = weChatManager.oaService().searchMeetingRoom(request, MEETING_ROOM);
        logger.info("查询会议室--{}", response);
    }

    /**
     * schedule e83328773e32d0d0fc15b5ffd11c709b
     * meeting-id mtWbKKTiLiDmghAIYJhGO8KmCeXQ-W3TAF1N5KGsv2S_8
     */
    @Test
    public void bookMeetingRoom() {
        BookMeetingRoomRequest request = new BookMeetingRoomRequest();
        request.setMeetingRoomId("1");
        request.setBooker("20170410022717");
        request.setAttendees(Collections.singletonList("20200914034599"));
        request.setSubject("讨论JTYY-1273需求");
        request.setStartTime(getUnixTime("2021-07-21 08:00:00"));
        request.setEndTime(getUnixTime("2021-07-21 11:00:00"));
        BookMeetingRoomResponse response = weChatManager.oaService().bookMeetingRoom(request, MEETING_ROOM);
        logger.info("预定会议室--{}", response);
    }

    @Test
    public void cancelBookMeetingRoom() {
        CancelBookRequest request = new CancelBookRequest();
        request.setKeepSchedule(0);
        request.setMeetingId("mtWbKKTiLiDmghAIYJhGO8KmCeXQ-W3TAF1N5KGsv2S_8");
        weChatManager.oaService().cancelBookMeetingRoom(request, MEETING_ROOM);
        logger.info("取消预定会议室--成功");
    }

    @Test
    public void delMeetingRoom() {
        MeetingRoomRequest request = new MeetingRoomRequest();
        request.setMeetingRoomId("1");
        weChatManager.oaService().delMeetingRoom(request, MEETING_ROOM);
        logger.info("删除会议室--成功");
    }

    private Long getUnixTime(String date) {
        try {
            return DateUtils.parseDate(date, "yyyy-MM-dd HH:mm:ss").getTime() / 1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Test
    public void punchCorrection() throws ParseException {
        PunchCorrectionRequest request = new PunchCorrectionRequest();
        request.setUserId("20170410022717");
        request.setScheduleDateTime(DateUtils.parseDate("2022-08-01 09:00","yyyy-MM-dd HH:mm"));
        request.setCheckinTime(DateUtils.parseDate("2022-09-01 09:00","yyyy-MM-dd HH:mm"));
        request.setScheduleCheckinTime(32400);
        weChatManager.oaService().punchCorrection(request, CHECK_IN);
    }
}
