package io.github.wangdingfu.service;

import io.github.wangdingfu.response.auth.ProviderTokenResponse;
import io.github.wangdingfu.resquest.auth.ProviderTokenRequest;
import org.springframework.stereotype.Service;

/**
 * @author ddshuai
 * date 2022-09-05 21:55
 **/
@Service
public class ServiceProviderService extends AbstractBaseService {

    /**
     * 获取服务商凭证
     * @param request 请求
     * @return 凭证信息
     */
    public ProviderTokenResponse getProviderToken(ProviderTokenRequest request) {
        return serviceProviderClient.getProviderToken(request);
    }
}
