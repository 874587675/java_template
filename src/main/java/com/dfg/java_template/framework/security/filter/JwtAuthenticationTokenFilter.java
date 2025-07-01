package com.dfg.java_template.framework.security.filter;

import cn.hutool.core.util.ObjectUtil;
import com.dfg.java_template.common.constant.CacheConstants;
import com.dfg.java_template.common.exception.token.TokenInvalidException;
import com.dfg.java_template.common.exception.token.TokenRequiredException;
import com.dfg.java_template.framework.redis.RedisCache;
import com.dfg.java_template.framework.security.constant.LoginRole;
import com.dfg.java_template.framework.security.core.AuthenticationContextHolder;
import com.dfg.java_template.framework.security.param.LoginUser;
import com.dfg.java_template.framework.security.service.TokenService;
import com.dfg.java_template.framework.security.util.SecurityUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@Slf4j
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Resource(name = "JJWTService")
    private TokenService tokenService;

    @Resource
    private RedisCache redisCache;

    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain chain) throws ServletException, IOException {
        LoginUser loginUser = new LoginUser();
        if (!isVerifyRequest(request)) {
            chain.doFilter(request, response);
            return;
        }
        String token = tokenService.getToken(request, response);
        if (ObjectUtil.isEmpty(token)) {
            throw new TokenRequiredException();
        }
        if (ObjectUtil.isNotEmpty(token) && ObjectUtil.isEmpty(SecurityUtils.getAuthentication())) {
            Claims claims = tokenService.parseToken(token);
            boolean flag = tokenService.verifyToken(token);
            if (!flag) {
                throw new TokenInvalidException();
            }
            String userId = claims.get("userId", String.class);
            String role = claims.get("role", String.class);

            if (LoginRole.FRONT_ROLE.getCode().equals(role)) {
                loginUser = redisCache.getCacheObject(CacheConstants.LOGIN_USER + CacheConstants.FRONT_KEY + userId);
                AuthenticationContextHolder.setFrontUserId(userId);
            }
            if (LoginRole.BACK_ROLE.getCode().equals(role)) {
                loginUser = redisCache.getCacheObject(CacheConstants.LOGIN_USER + CacheConstants.BACK_KEY + userId);
                AuthenticationContextHolder.setBackUserId(userId);
            }
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        chain.doFilter(request, response);
    }

    private boolean isVerifyRequest(HttpServletRequest request) {
        PathMatcher pathMatcher = new AntPathMatcher();
        String uri = request.getRequestURI();
        String[] securePatterns = {
                "/**/front/**",  // 匹配任意层级的front路径
                "/**/back/**",   // 匹配任意层级的back路径
        };
        return Arrays.stream(securePatterns)
                .anyMatch(pattern -> pathMatcher.match(pattern, uri));
    }
}