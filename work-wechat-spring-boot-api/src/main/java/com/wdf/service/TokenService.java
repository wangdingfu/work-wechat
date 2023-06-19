package com.wdf.service;

import com.wdf.response.tool.AccessTokenResponse;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 描述 访问令牌管理
 *
 * @author ddshuai
 * date 2019-04-04 17:28
 **/
@Service
public class TokenService extends AbstractBaseService {

    /**
     * 获取企业微信应用的access token
     *
     * @param applicationName 应用名称
     * @return String
     */
    @Cacheable(value = "work-wechat", key = "'work-wechat_access_token_'+#applicationName")
    public String getAccessToken(String applicationName) {
        if (logger.isInfoEnabled()) {
            logger.info("调用接口获取AccessToken：应用名称-{}", applicationName);
        }
        AccessTokenResponse accessTokenResponse = weChatClient.getAccessToken(properties.getCorpId(), getApplicationSecret(applicationName));
        return accessTokenResponse.getAccessToken();
    }

    /**
     * 清除应用AccessToken缓存
     *
     * @param cacheApplicationName 应用名称
     */
    @CacheEvict(value = "work-wechat", key = "'work-wechat_access_token_'+#cacheApplicationName")
    public void clearAccessToken(String cacheApplicationName) {

    }
}
