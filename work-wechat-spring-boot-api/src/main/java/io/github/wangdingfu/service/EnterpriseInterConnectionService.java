package io.github.wangdingfu.service;

import io.github.wangdingfu.response.corp.AppShareInfoResponse;
import io.github.wangdingfu.response.corp.TransferSessionResponse;
import io.github.wangdingfu.response.tool.AccessTokenResponse;
import io.github.wangdingfu.resquest.corp.AppShareInfoRequest;
import io.github.wangdingfu.resquest.corp.CorpTokenRequest;
import io.github.wangdingfu.resquest.corp.TransferSessionRequest;
import org.springframework.stereotype.Service;

/**
 * 企业互联
 */
@Service
public class EnterpriseInterConnectionService extends AbstractBaseService {

    /**
     * 获取应用共享信息
     *
     * @param request         请求
     * @param applicationName 应用
     * @return 应用共享信息
     */
    public AppShareInfoResponse appShareInfo(AppShareInfoRequest request, String applicationName) {
        return enterpriseInterConnectionClient.appShareInfo(request, applicationName);
    }

    /**
     * 获取accessToken
     *
     * @param request         请求
     * @param applicationName 应用
     * @return 获取accessToken
     */
    public AccessTokenResponse getToken(CorpTokenRequest request, String applicationName) {
        return enterpriseInterConnectionClient.getToken(request, applicationName);
    }

    /**
     * 获取下级/下游企业小程序session
     *
     * @param request         请求
     * @param applicationName 应用
     * @return 下级/下游企业小程序session
     */
    public TransferSessionResponse transferSession(TransferSessionRequest request, String applicationName) {
        return enterpriseInterConnectionClient.transferSession(request, applicationName);
    }
}
