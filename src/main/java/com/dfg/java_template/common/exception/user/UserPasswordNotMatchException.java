package com.dfg.java_template.common.exception.user;

import java.io.Serial;

/**
 * 用户密码不匹配异常类
 * 
 * @author zgc
 */
public class UserPasswordNotMatchException extends UserException
{
    @Serial
    private static final long serialVersionUID = 1L;

    public UserPasswordNotMatchException()
    {
        super(20001, "user.password.not.match", null);
    }
}
