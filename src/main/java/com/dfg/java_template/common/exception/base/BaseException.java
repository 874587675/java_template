package com.dfg.java_template.common.exception.base;


import cn.hutool.core.util.ObjectUtil;
import com.dfg.java_template.common.util.message.MessageUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;

/**
 * 基础异常
 *
 * @author zgc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 所属模块
     */
    private String module;

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误码对应的参数
     */
    private Object[] args;

    /**
     * 错误消息
     */
    private String message;

    /**
     * 错误消息
     */
    private String defaultMessage = "系统异常";

    public BaseException(String module, Integer code, Object[] args, String message) {
        this(module, code, args, message, null);
    }

    public BaseException(String module, String defaultMessage) {
        this(module, null, null, null, defaultMessage);
    }

    public BaseException(Integer code, String message, Object[] args) {
        this(null, code, args, message, null);
    }

    public BaseException(String defaultMessage) {
        this(null, null, null, null, defaultMessage);
    }

    @Override
    public String getMessage() {
        String result = null;
        if (!ObjectUtil.isEmpty(this.message)) {
            result = MessageUtils.message(this.message, this.args);
        }
        if (result == null) {
            result = this.defaultMessage;
        }
        return result;
    }

}
