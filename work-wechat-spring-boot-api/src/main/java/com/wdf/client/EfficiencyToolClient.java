package com.wdf.client;

import com.wdf.client.config.WeChatConfiguration;
import com.wdf.response.BaseResponse;
import com.wdf.response.tool.*;
import com.wdf.response.wedrive.*;
import com.wdf.resquest.tool.*;
import com.wdf.resquest.wedrive.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 效率工具
 *
 * @author ddshuai
 * date 2022-09-01 09:37
 **/
@FeignClient(name = "EfficiencyToolClient", url = "${work-wechat.url:https://qyapi.weixin.qq.com}", path = "${work-wechat.public-path:cgi-bin}", configuration = WeChatConfiguration.class)
public interface EfficiencyToolClient extends CommonClient {

    /**
     * 创建预约直播
     *
     * @param request 请求体
     * @param app     应用名
     * @return CreateLivingResponse
     */
    @PostMapping(value = "living/create", headers = HEAD)
    CreateLivingResponse createLiving(LivingRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 修改预约直播
     *
     * @param request 请求体
     * @param app     应用名
     * @return BaseResponse
     */
    @PostMapping(value = "living/modify", headers = HEAD)
    BaseResponse modifyLiving(LivingRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 取消预约直播
     *
     * @param request 请求体
     * @param app     应用名
     * @return BaseResponse
     */
    @PostMapping(value = "living/cancel", headers = HEAD)
    BaseResponse cancelLiving(CancelLivingRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 删除直播回放
     *
     * @param request 请求体
     * @param app     应用名
     * @return BaseResponse
     */
    @PostMapping(value = "living/delete_replay_data", headers = HEAD)
    BaseResponse delLiving(DeleteLivingRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 获取微信观看直播凭证
     *
     * @param request 请求体
     * @param app     应用名
     * @return LivingCodeResponse
     */
    @PostMapping(value = "living/get_living_code", headers = HEAD)
    LivingCodeResponse getLivingCode(LivingCodeRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 获取成员直播ID列表
     *
     * @param request 请求体
     * @param app     应用名
     * @return GetUserLivingResponse
     */
    @PostMapping(value = "living/get_user_all_livingid", headers = HEAD)
    GetUserLivingResponse getUserAllLivingId(GetUserLivingRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 获取直播详情
     *
     * @param livingId 直播编号
     * @param app      应用名
     * @return LivingInfoResponse
     */
    @GetMapping(value = "living/get_living_info", headers = HEAD)
    LivingInfoResponse getLivingInfo(@RequestParam("livingid") String livingId, @RequestParam(HEAD_KEY) String app);

    /**
     * 获取直播观看明细
     *
     * @param request 请求体
     * @param app     应用名
     * @return WatchStatInfoResponse
     */
    @PostMapping(value = "living/get_watch_stat", headers = HEAD)
    WatchStatInfoResponse getWatchStat(GetWatchStatRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 获取跳转小程序商城的直播观众信息
     *
     * @param request 请求体
     * @param app     应用名
     * @return LivingShareResponse
     */
    @PostMapping(value = "living/get_living_share_info", headers = HEAD)
    LivingShareResponse getLivingShareInfo(LivingShareRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 创建预约会议
     *
     * @param request 请求体
     * @param app     应用名
     * @return CreateMeetingResponse
     */
    @PostMapping(value = "meeting/create", headers = HEAD)
    CreateMeetingResponse createMeeting(MeetingRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 修改预约会议
     *
     * @param request 请求体
     * @param app     应用名
     * @return BaseResponse updateMeeting(MeetingRequest request, @RequestParam(HEAD_KEY) String app);
     */
    @PostMapping(value = "meeting/update", headers = HEAD)
    BaseResponse updateMeeting(MeetingRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 取消预约会议
     *
     * @param request 请求体
     * @param app     应用名
     * @return BaseResponse
     */
    @PostMapping(value = "meeting/cancel", headers = HEAD)
    BaseResponse cancelMeeting(CancelMeetingRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 获取成员会议ID列表
     *
     * @param request 请求体
     * @param app     应用名
     * @return GetMeetingForUserResponse
     */
    @PostMapping(value = "meeting/get_user_meetingid", headers = HEAD)
    GetMeetingForUserResponse getUserMeetingId(GetMeetingForUserRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 获取会议详情
     *
     * @param request 请求体
     * @param app     应用名
     * @return MeetingDetailResponse
     */
    @PostMapping(value = "meeting/get_info", headers = HEAD)
    MeetingDetailResponse getMeetingInfo(GetMeetingDetailRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 获取公费电话拨打记录
     *
     * @param request 请求体
     * @param app     应用名
     * @return DialRecordResponse
     */
    @PostMapping(value = "dial/get_dial_record", headers = HEAD)
    DialRecordResponse getDialRecord(DialRecordRequest request, @RequestParam(HEAD_KEY) String app);

    /* *************************************** 微盘 *************************************** */

    /**
     * 新建空间
     *
     * @param request 请求
     * @param app     应用名
     * @return 空间编号
     */
    @PostMapping(value = "wedrive/space_create", headers = HEAD)
    CreateSpaceResponse createSpace(CreateSpaceRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 该接口用于重命名已有空间，接收userid参数，以空间管理员身份来重命名
     *
     * @param request 请求
     * @param app     应用名
     * @return 操作结果
     */
    @PostMapping(value = "wedrive/space_rename", headers = HEAD)
    BaseResponse renameSpace(RenameSpaceRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 该接口用于解散已有空间，需要以空间管理员身份来解散。
     *
     * @param request 请求
     * @param app     应用名
     * @return 操作结果
     */
    @PostMapping(value = "wedrive/space_dismiss", headers = HEAD)
    BaseResponse dismissSpace(DismissSpaceRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 获取空间/相册信息
     *
     * @param request 请求
     * @param app     应用名
     * @return 空间信息
     */
    @PostMapping(value = "wedrive/space_info", headers = HEAD)
    SpaceInfoResponse spaceInfo(SpaceInfoRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 添加成员/部门
     *
     * @param request 请求
     * @param app     应用名
     * @return 操作结果
     */
    @PostMapping(value = "wedrive/space_acl_add", headers = HEAD)
    BaseResponse addSpaceAcl(SpaceAclRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 移除成员/部门
     *
     * @param request 请求
     * @param app     应用名
     * @return 操作结果
     */
    @PostMapping(value = "wedrive/space_acl_del", headers = HEAD)
    BaseResponse delSpaceAcl(SpaceAclRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 安全设置
     *
     * @param request 请求
     * @param app     应用名
     * @return 操作结果
     */
    @PostMapping(value = "wedrive/space_setting", headers = HEAD)
    BaseResponse spaceSetting(SpaceSettingRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 获取邀请链接
     *
     * @param request 请求
     * @param app     应用名
     * @return 操作结果
     */
    @PostMapping(value = "wedrive/space_share", headers = HEAD)
    SpaceShareResponse spaceShare(CommonSpaceRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 获取文件列表
     *
     * @param request 请求
     * @param app     应用名
     * @return 文件列表
     */
    @PostMapping(value = "wedrive/file_list", headers = HEAD)
    SpaceFileResponse listFile(QueryFileRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 获取文件列表
     *
     * @param request 请求
     * @param app     应用名
     * @return 文件编号 地址
     */
    @PostMapping(value = "wedrive/file_create", headers = HEAD)
    CreateFileResponse createFile(CreateFileRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 上传文件
     *
     * @param request 请求
     * @param app     应用名
     * @return 文件编号 地址
     */
    @PostMapping(value = "wedrive/file_upload", headers = HEAD)
    CreateFileResponse uploadFile(UploadFileRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 下载文件
     *
     * @param request 请求
     * @param app     应用名
     * @return 文件地址
     */
    @PostMapping(value = "wedrive/file_download", headers = HEAD)
    DownloadFileResponse downloadFile(DownloadFileRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 重命名文件
     *
     * @param request 请求
     * @param app     应用名
     * @return 文件信息
     */
    @PostMapping(value = "wedrive/file_rename", headers = HEAD)
    RenameFileResponse renameFile(RenameFileRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 移动文件
     *
     * @param request 请求
     * @param app     应用名
     * @return 文件信息
     */
    @PostMapping(value = "wedrive/file_move", headers = HEAD)
    MoveFileResponse moveFile(MoveFileRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 删除文件
     *
     * @param request 请求
     * @param app     应用名
     * @return 操作结果
     */
    @PostMapping(value = "wedrive/file_delete", headers = HEAD)
    BaseResponse deleteFile(DeleteFileRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 文件信息
     *
     * @param request 请求
     * @param app     应用名
     * @return 操作结果
     */
    @PostMapping(value = "wedrive/file_info", headers = HEAD)
    FileInfoResponse fileInfo(FileInfoRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 文件权限 新增成员
     *
     * @param request 请求
     * @param app     应用名
     * @return 操作结果
     */
    @PostMapping(value = "wedrive/file_acl_add", headers = HEAD)
    BaseResponse addFileAcl(FileAclRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 文件权限 删除成员
     *
     * @param request 请求
     * @param app     应用名
     * @return 操作结果
     */
    @PostMapping(value = "wedrive/file_acl_del", headers = HEAD)
    BaseResponse delFileAcl(FileAclRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 文件权限 分享设置
     *
     * @param request 请求
     * @param app     应用名
     * @return 操作结果
     */
    @PostMapping(value = "wedrive/file_setting", headers = HEAD)
    BaseResponse fileSetting(FileSettingRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 文件权限 获取分享链接
     *
     * @param request 请求
     * @param app     应用名
     * @return 操作结果
     */
    @PostMapping(value = "wedrive/file_share", headers = HEAD)
    FileShareResponse getFileShare(FileInfoRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 获取盘专业版信息
     *
     * @param request 请求
     * @param app     应用名
     * @return 操作结果
     */
    @PostMapping(value = "wedrive/mng_pro_info", headers = HEAD)
    ProInfoResponse proInfo(ProInfoRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 获取盘容量信息
     *
     * @param request 请求
     * @param app     应用名
     * @return 容量信息
     */
    @PostMapping(value = "wedrive/mng_capacity", headers = HEAD)
    CapacityResponse capacity(ProInfoRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 分块上传初始化
     *
     * @param request 请求
     * @param app     应用名
     * @return 初始化信息
     */
    @PostMapping(value = "wedrive/file_upload_init", headers = HEAD)
    InitUploadFileResponse initUploadFile(InitUploadFileRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 分块上传文件
     *
     * @param request 请求
     * @param app     应用名
     * @return 操作结果
     */
    @PostMapping(value = "wedrive/file_upload_part", headers = HEAD)
    BaseResponse fileUploadPart(FileUploadPartRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 分块上传完成
     *
     * @param request 请求
     * @param app     应用名
     * @return 操作结果
     */
    @PostMapping(value = "wedrive/file_upload_finish", headers = HEAD)
    FileUploadFinishResponse fileUploadFinish(FileUploadFinishRequest request, @RequestParam(HEAD_KEY) String app);
}
