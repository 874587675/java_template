package com.dfg.java_template.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ServiceErrorEnum {
    /**
     * 登录令牌信息为空
     */
    TOKEN_EMPTY(10001, "登录令牌信息为空"),
    
    /**
     * 登录令牌信息失效
     */
    TOKEN_INVALID(10002, "登录令牌信息失效"),
    
    /**
     * 账号在其它设备登录
     */
    TOKEN_REMOTE_LOGIN(10003, "账号在其它设备登录"),
    
    ;
    
    
    private final Integer code;
    
    private final String desc;
    
    
}
