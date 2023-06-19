package io.github.wangdingfu.client;

import io.github.wangdingfu.client.config.WeChatConfiguration;
import io.github.wangdingfu.response.corp.AppShareInfoResponse;
import io.github.wangdingfu.response.corp.TransferSessionResponse;
import io.github.wangdingfu.response.tool.AccessTokenResponse;
import io.github.wangdingfu.resquest.corp.AppShareInfoRequest;
import io.github.wangdingfu.resquest.corp.CorpTokenRequest;
import io.github.wangdingfu.resquest.corp.TransferSessionRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 企业互联
 */
@FeignClient(name = "EnterpriseInterConnectionClient", url = "${work-wechat.url:https://qyapi.weixin.qq.com}", path = "${work-wechat.public-path:cgi-bin}", configuration = WeChatConfiguration.class)
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
