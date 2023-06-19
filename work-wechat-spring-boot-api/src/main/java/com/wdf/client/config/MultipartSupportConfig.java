package com.wdf.client.config;

import com.wdf.client.decoder.WeChatMediaDecoder;
import com.wdf.client.interceptor.WeChatInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.context.annotation.Bean;

/**
 * @author shuaidongdong
 */

public class MultipartSupportConfig {

    @Bean
    public Encoder feignFormEncoder() {
        return new SpringFormEncoder();
    }

    @Bean
    public Decoder decoder() {
        return new WeChatMediaDecoder();
    }

    @Bean
    public WeChatInterceptor weChatInterceptor() {
        return new WeChatInterceptor();
    }
}
