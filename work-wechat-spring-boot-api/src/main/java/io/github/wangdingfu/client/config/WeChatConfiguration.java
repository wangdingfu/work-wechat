package io.github.wangdingfu.client.config;

import io.github.wangdingfu.client.decoder.CustomJacksonDecoder;
import io.github.wangdingfu.client.interceptor.WeChatInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;

/**
 * 描述 企业微信feign客户端配置
 *
 * @author ddshuai
 * date 2019-04-04 16:18
 **/
public class WeChatConfiguration {

    @Bean
    public Decoder decoder() {
        return new CustomJacksonDecoder();
    }

    @Bean
    public Encoder encoder() {
        return new JacksonEncoder();
    }

    @Bean
    public WeChatInterceptor weChatInterceptor() {
        return new WeChatInterceptor();
    }
}
