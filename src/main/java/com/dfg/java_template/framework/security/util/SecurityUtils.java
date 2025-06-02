package com.dfg.java_template.framework.security.util;

import com.dfg.java_template.common.constant.HttpStatus;
import com.dfg.java_template.common.exception.ServiceException;
import com.dfg.java_template.framework.security.param.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 安全服务工具类
 *
 * @author zgc
 */
public class SecurityUtils {
    /**
     * 获取用户ID
     *
     * @return 用户ID
     */
    public static String getUserId() {
        try {
            return getLoginUser().getUserId();
        } catch (Exception e) {
            throw new ServiceException(HttpStatus.UNAUTHORIZED, "获取用户ID失败,请先登录");
        }
    }

    /**
     * 获取用户名称
     *
     * @return 用户名称
     */
    public static String getUsername() {
        try {
            return getLoginUser().getUsername();
        } catch (Exception e) {
            throw new ServiceException(HttpStatus.UNAUTHORIZED, "获取用户名称失败,请先登录");
        }
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    public static LoginUser getLoginUser() {
        try {
            return (LoginUser) getAuthentication().getPrincipal();
        } catch (Exception e) {
            throw new ServiceException(HttpStatus.UNAUTHORIZED, "获取用户信息异常,请先登录");
        }
    }

    /**
     * 获取Authentication
     *
     * @return Authentication对象
     */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 生成BCryptPasswordEncoder密码
     *
     * @param password 密码
     * @return 加密字符串
     */
    public static String encryptPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    /**
     * 判断密码是否相同
     *
     * @param encodedPassword 加密后字符
     * @param rawPassword     真实密码
     * @return 结果
     */
    public static boolean matchesPassword(String encodedPassword, String rawPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }


}