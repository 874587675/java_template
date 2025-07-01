package com.dfg.java_template.common.exception.token;

import java.io.Serial;

public class TokenRequiredException extends TokenException {
    @Serial
    private static final long serialVersionUID = 1L;

    public TokenRequiredException() {
        super(10001,"token.required", null);
    }
}
