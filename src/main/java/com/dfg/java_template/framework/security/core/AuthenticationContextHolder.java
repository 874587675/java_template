package com.dfg.java_template.framework.security.core;

import org.springframework.security.core.Authentication;

/**
 * 身份验证信息
 *
 * @author zgc
 */
public class AuthenticationContextHolder {
    /**
     * 前台用户
     */
    private static final ThreadLocal<Authentication> frontContextHolder = new ThreadLocal<>(); // ThreadLocal前台用户
    private static final ThreadLocal<String> frontUserIdHolder = new ThreadLocal<>(); // ThreadLocal前台用户ID

    public static Authentication getFrontContext() {
        return frontContextHolder.get(); //获取前台用户当前线程的身份验证信息
    }

    public static void setFrontContext(Authentication context) {
        frontContextHolder.set(context);    //设置前台用户当前线程的身份验证信息
    }

    public static void clearFrontContext() {
        frontContextHolder.remove();        //清除后台用户当前线程的身份验证信息
    }

    public static void setFrontUserId(String frontUserId) {
        frontUserIdHolder.set(frontUserId);
    }

    public static String getFrontUserId() {
        return frontUserIdHolder.get();
    }

    /**
     * 后台用户
     */
    private static final ThreadLocal<Authentication> backContextHolder = new ThreadLocal<>(); // ThreadLocal后台用户
    private static final ThreadLocal<String> backUserIdHolder = new ThreadLocal<>(); // ThreadLocal后台用户

    public static Authentication getBackContext() {
        return backContextHolder.get();     //获取后台用户当前线程的身份验证信息
    }

    public static void setBackContext(Authentication context) {
        backContextHolder.set(context);     //设置后台用户当前线程的身份验证信息
    }

    public static void clearBackContext() {
        backContextHolder.remove();         //清除后台用户当前线程的身份验证信息
    }

    public static void setBackUserId(String frontUserId) {
        backUserIdHolder.set(frontUserId);
    }

    public static String getBackUserId() {
        return backUserIdHolder.get();
    }

}
