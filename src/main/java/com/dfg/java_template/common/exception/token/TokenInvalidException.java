package com.dfg.java_template.common.exception.token;

import java.io.Serial;

public class TokenInvalidException extends TokenException{
    @Serial
    private static final long serialVersionUID = 1L;

    public TokenInvalidException() {
        super(10002,"token.invalid", null);
    }
}
