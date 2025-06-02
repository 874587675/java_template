package com.dfg.java_template.framework.security.config;

import com.dfg.java_template.framework.security.filter.JwtAuthenticationTokenFilter;
import com.dfg.java_template.framework.security.handle.AuthenticationEntryPointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

import javax.annotation.Resource;

/**
 * Spring Security配置类
 *
 * @author zgc
 */
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
@Configuration
public class SpringSecurityConfig {
    /**
     * 认证失败处理类
     */
    @Resource
    private AuthenticationEntryPointImpl unauthorizedHandler;
    /**
     * JWT过滤器
     */
    @Resource
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
    
    @Resource
    private UserDetailsService frontendUserDetailsService;

    @Resource
    private UserDetailsService backendUserDetailsService;

    @Resource
    private CorsFilter corsFilter;

    @Bean
    @Primary
    public AuthenticationManager frontendAuthenticationManager() throws Exception {
        // 为前台配置
        DaoAuthenticationProvider frontendProvider = new DaoAuthenticationProvider();
        frontendProvider.setUserDetailsService(frontendUserDetailsService);
        frontendProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return new ProviderManager(frontendProvider);
    }

    @Bean
    public AuthenticationManager backendAuthenticationManager() throws Exception {
        // 为后台配置
        DaoAuthenticationProvider backendProvider = new DaoAuthenticationProvider();
        backendProvider.setUserDetailsService(backendUserDetailsService);
        backendProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return new ProviderManager(backendProvider);
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                // 禁用CSRF保护
                .csrf(csrf -> csrf.disable())
                // 认证失败处理类
                .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .headers((headersCustomizer) -> {
                    headersCustomizer.cacheControl(cache -> cache.disable()).frameOptions(options -> options.sameOrigin());
                })
                // 授权配置
                .authorizeHttpRequests(requests -> {
                    //放行swagger相关接口
                    requests.antMatchers("/swagger-ui.html", "/swagger-ui/**", "/v2/api-docs/**", "/v3/api-docs/**", "/swagger-resources/**", "/webjars/**", "/doc.html").permitAll()
                            .antMatchers("/**/back/**", "/**/front/**").authenticated()
                            .anyRequest().permitAll();  // 其余请求放行
                })
                // 先添加JWT过滤器
                .addFilterAfter(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
                // 添加CORS过滤器
                .addFilterBefore(corsFilter, JwtAuthenticationTokenFilter.class)
                .build();
    }

    /**
     * 强散列哈希加密实现
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
