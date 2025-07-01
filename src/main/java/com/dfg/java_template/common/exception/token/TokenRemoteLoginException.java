package com.dfg.java_template.common.exception.token;

import java.io.Serial;

public class TokenRemoteLoginException extends TokenException {
    @Serial
    private static final long serialVersionUID = 1L;

    public TokenRemoteLoginException() {
        super("token.remote.login", null);
    }
}
