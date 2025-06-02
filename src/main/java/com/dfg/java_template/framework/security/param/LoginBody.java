package com.dfg.java_template.framework.security.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;

/**
 * 用户登录对象
 * 
 * @author zgc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginBody implements Serializable
{
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 用户密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 验证码
     */
    private String code;

    /**
     * 唯一标识
     */
    private String uuid;
}
