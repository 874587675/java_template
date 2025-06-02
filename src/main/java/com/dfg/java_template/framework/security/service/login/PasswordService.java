package com.dfg.java_template.framework.security.service.login;

import cn.hutool.core.util.ObjectUtil;
import com.dfg.java_template.common.constant.CacheConstants;
import com.dfg.java_template.common.exception.user.UserPasswordNotMatchException;
import com.dfg.java_template.common.exception.user.UserPasswordRetryLimitExceedException;
import com.dfg.java_template.framework.redis.RedisCache;
import com.dfg.java_template.framework.security.core.AuthenticationContextHolder;
import com.dfg.java_template.framework.security.param.ValidUser;
import com.dfg.java_template.framework.security.util.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


@Service
@Slf4j
public class PasswordService {

    @Value(value = "${user.password.maxRetryCount}")
    private int maxRetryCount; // 密码错误最大重试次数

    @Value(value = "${user.password.lockTime}")
    private int lockTime; // 密码错误锁定时间（分钟）

    @Resource
    private RedisCache redisCache;

    /**
     * 登录账户密码错误次数缓存键名
     *
     * @param username 用户名
     * @return 缓存键key
     */
    private String getCacheKey(String username) {
        return CacheConstants.PWD_ERR_CNT_KEY + username;
    }

    /**
     * 校验前台用户密码
     *
     * @param validUser 用户密码信息
     */
    public void validatePassword(ValidUser validUser) {
        // 获取当前用户的认证信息
        Authentication authentication = AuthenticationContextHolder.getContext();
        // 获取当前用户的输入认证对象
        String username = authentication.getName();
        // 获取当前用户的输入认证凭证
        String rawPassword = authentication.getCredentials().toString();
        // 从缓存中获取用户错误次数
        Integer retryCount = redisCache.getCacheObject(getCacheKey(username));

        if (ObjectUtil.isEmpty(retryCount)) {
            retryCount = 0;
        }
        if (retryCount >= maxRetryCount) {
            throw new UserPasswordRetryLimitExceedException(retryCount, lockTime);
        }
        String password = validUser.getPassword();
        if (!matches(password, rawPassword)) {
            retryCount += 1;
            redisCache.setCacheObject(getCacheKey(username), retryCount, lockTime, TimeUnit.MINUTES);
            throw new UserPasswordNotMatchException();
        }
    }

    
    
    

    /**
     * 密码匹配
     *
     * @param password    加密后的密码
     * @param rawPassword 明文密码
     * @return 是否匹配
     */
    public boolean matches(String password, String rawPassword) {
        return SecurityUtils.matchesPassword(password, rawPassword);
    }
    
}
