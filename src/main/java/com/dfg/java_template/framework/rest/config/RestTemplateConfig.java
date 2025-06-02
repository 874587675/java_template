package com.dfg.java_template.framework.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        // 设置连接超时和读取超时时间（单位：毫秒）
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(5000);    // 连接超时5秒
        factory.setReadTimeout(10000);      // 读取超时10秒
        
        return new RestTemplate(factory);
    }
}