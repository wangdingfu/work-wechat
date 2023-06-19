package com.wdf.client;

import com.wdf.client.config.WeChatConfiguration;
import com.wdf.response.corp.AppShareInfoResponse;
import com.wdf.response.corp.TransferSessionResponse;
import com.wdf.response.tool.AccessTokenResponse;
import com.wdf.resquest.corp.AppShareInfoRequest;
import com.wdf.resquest.corp.CorpTokenRequest;
import com.wdf.resquest.corp.TransferSessionRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 企业互联
 */
@FeignClient(name = "EnterpriseInterConnectionClient", url = "${qywx.url:https://qyapi.weixin.qq.com}", path = "${qywx.public-path:cgi-bin}", configuration = WeChatConfiguration.class)
public interface EnterpriseInterConnectionClient extends CommonClient {

    /**
     * 获取应用共享信息
     *
     * @param request 请求
     * @param app     应用
     * @return 应用共享信息
     */
    @PostMapping(value = "/corpgroup/corp/list_app_share_info", headers = HEAD)
    AppShareInfoResponse appShareInfo(AppShareInfoRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 获取accessToken
     *
     * @param request 请求
     * @param app     应用
     * @return 获取accessToken
     */
    @PostMapping(value = "/corpgroup/corp/gettoken", headers = HEAD)
    AccessTokenResponse getToken(CorpTokenRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 获取下级/下游企业小程序session
     *
     * @param request 请求
     * @param app     应用
     * @return 应用共享信息
     */
    @PostMapping(value = "/miniprogram/transfer_session", headers = HEAD)
    TransferSessionResponse transferSession(TransferSessionRequest request, @RequestParam(HEAD_KEY) String app);
}
