package com.dfg.java_template.framework.config.cors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 全局跨域配置
 *
 * @author zgc
 */
@Configuration
public class GlobalCorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        // 1. 创建CORS配置对象
        CorsConfiguration config = new CorsConfiguration();
        // 2. 允许的域（不要设为*，否则cookie无法跨域）
        config.addAllowedOrigin("*");
        // 3. 允许的请求头
        config.addAllowedHeader("*");
        // 4. 允许的HTTP方法
        config.addAllowedMethod("*");
        // 5. 是否允许发送Cookie
        config.setAllowCredentials(true);
        // 6. 预检请求缓存时间（秒）
        config.setMaxAge(3600L);
        // 7. 注册配置到所有路径
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}