package com.dfg.java_template.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public final class ServiceException extends RuntimeException implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer code;
    private String message;

    public ServiceException() {

    }

    public ServiceException(String message) {
        super(message);
        this.code = 500;
        this.message = message;
    }

    public ServiceException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
    

}
