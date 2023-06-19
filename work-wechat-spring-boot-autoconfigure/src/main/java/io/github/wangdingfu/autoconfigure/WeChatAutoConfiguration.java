package io.github.wangdingfu.autoconfigure;

import io.github.wangdingfu.client.config.WeChatConfigurationProperties;
import io.github.wangdingfu.support.CallBackManager;
import io.github.wangdingfu.support.WeChatContextHolder;
import io.github.wangdingfu.support.WeChatManager;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

/**
 * 描述
 *
 * @author ddshuai
 * date 2019-04-03 15:46
 * @author shuaidongdong
 */
@Configuration
@ComponentScan(basePackages = {"io.github.wangdingfu.service", "io.github.wangdingfu.support", "io.github.wangdingfu.aspect"})
@EnableConfigurationProperties(WeChatConfigurationProperties.class)
public class WeChatAutoConfiguration implements InitializingBean {

    private final WeChatConfigurationProperties properties;
    private final WeChatManager weChatManager;

    public WeChatAutoConfiguration(WeChatConfigurationProperties properties, WeChatManager weChatManager) {
        this.properties = properties;
        this.weChatManager = weChatManager;
    }

    @ConditionalOnMissingBean(CacheManager.class)
    @Bean
    public CacheManager cacheManager() {
        ConcurrentMapCacheManager concurrentMapCacheManager = new ConcurrentMapCacheManager();
        concurrentMapCacheManager.setAllowNullValues(true);
        concurrentMapCacheManager.setCacheNames(Collections.singletonList("work-wechat"));
        return concurrentMapCacheManager;
    }

    @Override
    public void afterPropertiesSet() {
        CallBackManager.properties(properties.getCallbackList());
        WeChatContextHolder.setWeChatManager(weChatManager);
    }
}
