package com.dfg.java_template.framework.security.core;

import org.springframework.security.core.Authentication;

/**
 * 身份验证信息
 *
 * @author zgc
 */
public class AuthenticationContextHolder {

    private static final ThreadLocal<Authentication> contextHolder = new ThreadLocal<>(); // ThreadLocal对象

    public static Authentication getContext() {
        return contextHolder.get(); //获取当前线程的身份验证信息
    }   

    public static void setContext(Authentication context) {
        contextHolder.set(context);
    }   //设置当前线程的身份验证信息

    public static void clearContext() {
        contextHolder.remove();
    }   //清除当前线程的身份验证信息

    
}
