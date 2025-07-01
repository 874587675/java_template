package com.dfg.java_template.common.exception.token;

import com.dfg.java_template.common.exception.base.BaseException;

import java.io.Serial;


/**
 * 身份凭证异常类
 *
 * @author zgc
 */
public class TokenException extends BaseException {
    @Serial
    private static final long serialVersionUID = 1L;

    public TokenException(Integer code, String message, Object[] args) {
        super("token", code, args, message, null);
    }
}
