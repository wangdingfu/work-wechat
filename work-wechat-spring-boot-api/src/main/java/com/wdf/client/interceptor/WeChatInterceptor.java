package com.wdf.client.interceptor;


import com.wdf.client.WeChatClient;
import com.wdf.support.WeChatContextHolder;
import com.wdf.support.WeChatManager;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 处理所有请求的access_token参数
 *
 * @author ddshuai
 * date 2019-04-04 16:20
 **/

public class WeChatInterceptor implements RequestInterceptor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 统一处理AccessToken
     *
     * @param template 请求模板
     */
    @Override
    public void apply(RequestTemplate template) {
        //需要把获取token的请求过滤掉
        if (!template.url().startsWith(WeChatClient.GET_TOKEN)) {
            String app = "";
            Collection<String> headerApp = template.headers().get(WeChatClient.HEAD_KEY);
            if (CollectionUtils.isNotEmpty(headerApp)) {
                String realApp = new ArrayList<>(headerApp).get(0);
                if (StringUtils.isNotEmpty(realApp)) {
                    app = realApp;
                }
            }

            if (StringUtils.isEmpty(app)) {
                throw new RuntimeException("请求未传递应用名，无法调起接口");
            }

            WeChatManager weChatManager = WeChatContextHolder.getWeChatManager();
            String accessToken = weChatManager.tokenService().getAccessToken(app);
            template.query(WeChatClient.ACCESS_TOKEN, accessToken);
            if (weChatManager.properties().getDebugMode()) {
                template.query(WeChatClient.DEBUG, "1");
            }
        }

        if (logger.isInfoEnabled()) {
            logger.info("实际请求地址：{}", template.url());
        }
    }
}
