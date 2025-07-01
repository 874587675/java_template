package com.dfg.java_template.common.exception.user;

import com.dfg.java_template.common.exception.base.BaseException;

import java.io.Serial;


/**
 * 用户信息异常类
 *
 * @author zgc
 */
public class UserException extends BaseException {
    @Serial
    private static final long serialVersionUID = 1L;

    public UserException(Integer code, String message, Object[] args) {
        super("user", code, args, message, null);
    }
}
