package com.dfg.java_template.framework.security.service;

import cn.hutool.core.util.ObjectUtil;
import com.dfg.java_template.common.constant.CacheConstants;
import com.dfg.java_template.common.constant.CommonConstants;
import com.dfg.java_template.framework.redis.RedisCache;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@ConfigurationProperties("token")
@Component("JJWTService")
@Data
@Slf4j
public class TokenService {
    @Resource
    private RedisCache redisCache;

    private TokenParam tokenParam;

    private Key key;

    private static final long MINUTE_MILLISECOND = 60 * 1000L; // 1分钟的毫秒数

    private static final long HOUR_MILLISECOND = 60 * MINUTE_MILLISECOND;

    /**
     * 初始化密钥
     */
    @PostConstruct
    public void init() {
        log.info("正在初始化JWT密钥==========>>");
        String secret = tokenParam.getSecret();
        if (secret.length() < 32) {
            throw new IllegalArgumentException("密钥长度不足，必须至少为 256 位。"); // 确保 secret 长度至少为 256 位（32 字节）
        }
        // 使用secret来生成密钥
        this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8)); // 使用字节数组来生成密钥
        log.info("初始化JWT密钥成功==========>>");
    }

    /**
     * 从数据声明生成令牌
     *
     * @param userId 用户主键ID
     * @param claims 数据声明
     * @return 令牌
     */
    public String generateToken(String userId, Map<String, Object> claims) {
        int expireMinutes = tokenParam.getExpireTime(); //单位分钟

        String compact = Jwts.builder()
                .setSubject(userId)  //标识token是给谁使用
                .setClaims(claims)     //自定义数据
                .setIssuedAt(new Date())   //token签发时间
                .setExpiration(new Date(System.currentTimeMillis() + expireMinutes * MINUTE_MILLISECOND)) //token过期时间
                .signWith(key) //使用密钥进行签名
                .compact();

        log.info("生成token令牌成功");

        redisCache.setCacheObject(CacheConstants.LOGIN_TOKEN_USER + userId, compact, expireMinutes, TimeUnit.MINUTES);    //将令牌存入redis中
        return compact;
    }

    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    public Claims parseToken(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            log.error("解析token失败: {}", e.getMessage());
            return null;
        }
    }

    /**
     * 验证令牌是否有效（是否过期，是否同一用户）
     *
     * @param token 令牌
     * @return true:有效 false:无效
     */
    public boolean verifyToken(String token) {
        try {
            Claims claims = parseToken(token);
            Date expiration = claims.getExpiration();
            return !expiration.before(new Date());
        } catch (Exception e) {
            log.error("验证token失败: {}", e.getMessage());
            return false;
        }
    }

    /**
     * 获取请求token、刷新token
     *
     * @param httpServletRequest 请求对象
     * @return 用户名
     */
    public String getToken(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String token = httpServletRequest.getHeader(tokenParam.getHeader());
        
        if (ObjectUtil.isNotEmpty(token) && token.startsWith(CommonConstants.TOKEN_PREFIX)) {
            token = token.replace(CommonConstants.TOKEN_PREFIX, "");
            Claims claims = parseToken(token);
            String userId = claims.get("userId", String.class);
            Date expiration = claims.getExpiration();
            long nowTime = System.currentTimeMillis();
            if ((expiration.getTime() - nowTime) <= tokenParam.getRefreshMinTime() * MINUTE_MILLISECOND) {
                String refreshToken = generateToken(userId, claims);
                httpServletResponse.setHeader("X-Refresh-Token", refreshToken);
                redisCache.expire(CacheConstants.LOGIN_USER + userId , tokenParam.getExpireTime(), TimeUnit.MINUTES);
            }
        }
        return token;
    }


    @Data
    public static class TokenParam {
        private String header; //令牌自定义标识
        private String secret; //令牌密钥
        private int expireTime; //令牌过期时间 单位分钟
        private int refreshMinTime; //令牌有效期小于等于该时间时刷新令牌
    }

}
