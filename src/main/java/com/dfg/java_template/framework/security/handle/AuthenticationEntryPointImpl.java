package com.dfg.java_template.framework.security.handle;

import com.alibaba.fastjson2.JSON;
import com.dfg.java_template.common.constant.HttpStatus;
import com.dfg.java_template.framework.util.servlet.ServletUtils;
import com.dfg.java_template.framework.web.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;

/**
 * 认证失败处理类 返回未授权
 *
 * @author zgc
 */
@Slf4j
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
            throws IOException {
        log.error("\n认证失败\n路径: {} \n异常类型: {}\n原因: {}\n",
                request.getRequestURI(),
                e.getClass().getSimpleName(),
                e.getMessage());

        ServletUtils.renderString(response, JSON.toJSONString(new AjaxResult(HttpStatus.UNAUTHORIZED, e.getMessage(), request.getRequestURI())));
    }


}
