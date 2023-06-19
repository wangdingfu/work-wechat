package com.wdf.client;

import com.wdf.client.config.WeChatConfiguration;
import com.github.shuaidd.response.addressbook.*;
import com.github.shuaidd.response.kf.*;
import com.wdf.response.material.UploadByUrlResultResponse;
import com.github.shuaidd.response.oa.*;
import com.github.shuaidd.response.tool.*;
import com.github.shuaidd.resquest.addressbook.*;
import com.wdf.resquest.job.JobIdRequest;
import com.github.shuaidd.resquest.kf.*;
import com.wdf.resquest.media.UploadByUrlRequest;
import com.github.shuaidd.resquest.oa.*;
import com.github.shuaidd.resquest.tool.*;
import com.wdf.response.addressbook.AsyncJobResponse;
import com.wdf.response.addressbook.ExportResultResponse;
import com.wdf.response.addressbook.MobileHashCodeResponse;
import com.wdf.response.tool.AccessTokenResponse;
import com.wdf.response.tool.ApiDomainIpResponse;
import com.wdf.response.tool.OpenUserId2UserIdResponse;
import com.wdf.response.tool.TransformExternalUserIdResponse;
import com.wdf.resquest.addressbook.MobileHashCodeRequest;
import com.wdf.resquest.tool.OpenUserId2UserIdRequest;
import com.wdf.resquest.tool.TransformExternalUserIdRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 描述 enjoy your life
 *
 * @author ddshuai
 * date 2019-04-03 15:50
 **/
@SuppressWarnings("all")
@FeignClient(name = "wechat", url = "${qywx.url:https://qyapi.weixin.qq.com}", path = "${qywx.public-path:cgi-bin}", configuration = WeChatConfiguration.class)
public interface WeChatClient extends CommonClient {

    /**
     * 获取应用 access token
     *
     * @param corpId 企业号
     * @param secret 密匙
     * @return AccessTokenResponse
     */
    @GetMapping("gettoken")
    AccessTokenResponse getAccessToken(@RequestParam("corpid") String corpId, @RequestParam("corpsecret") String secret);

    /**
     * 获取手机号随机串
     *
     * @param request 请求体
     * @param app     应用名
     * @return MobileHashCodeResponse
     */
    @PostMapping(value = "user/get_mobile_hashcode", headers = HEAD)
    MobileHashCodeResponse getMobileHashcode(MobileHashCodeRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 获取企业微信API域名IP段
     *
     * @param app 应用名
     * @return ApiDomainIpResponse
     */
    @GetMapping(value = "get_api_domain_ip", headers = HEAD)
    ApiDomainIpResponse apiDomainIp(@RequestParam(HEAD_KEY) String app);

    /**
     * 获取企业微信服务器回调的ip段
     *
     * @param app 应用名
     * @return ApiDomainIpResponse
     */
    @GetMapping(value = "getcallbackip", headers = HEAD)
    ApiDomainIpResponse callBackIp(@RequestParam(HEAD_KEY) String app);

    /**
     * 获取导出结果
     *
     * @param jobId 任务编号
     * @param app   应用名
     * @return 结果
     */
    @GetMapping(value = "export/get_result", headers = HEAD)
    ExportResultResponse getExportResult(@RequestParam("jobid") String jobId, @RequestParam(HEAD_KEY) String app);

    /**
     * userid转换
     * 将代开发应用或第三方应用获取的密文open_userid转换为明文userid。
     * @param request 请求
     * @param app   应用名
     * @return 结果
     */
    @PostMapping(value = "batch/openuserid_to_userid", headers = HEAD)
    OpenUserId2UserIdResponse openUserId2UserId(OpenUserId2UserIdRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * external_userid转换
     * 将代开发应用或第三方应用获取的externaluserid转换成自建应用的externaluserid。
     * @param request 请求
     * @param app   应用名
     * @return 结果
     */
    @PostMapping(value = "batch/openuserid_to_userid", headers = HEAD)
    TransformExternalUserIdResponse transformExternalUserId(TransformExternalUserIdRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 生成异步上传任务
     * @param request 请求
     * @param app 应用
     * @return 异步任务编号
     */
    @PostMapping(value = "media/upload_by_url", headers = HEAD)
    AsyncJobResponse uploadByUrl(UploadByUrlRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 查询异步任务结果
     * @param request 请求
     * @param app 应用
     * @return 异步任务执行结果
     */
    @PostMapping(value = "media/get_upload_by_url_result", headers = HEAD)
    UploadByUrlResultResponse getUploadByUrlResult(JobIdRequest request, @RequestParam(HEAD_KEY) String app);
}
