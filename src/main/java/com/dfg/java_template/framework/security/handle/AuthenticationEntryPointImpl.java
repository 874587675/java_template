package com.dfg.java_template.framework.security.handle;

import com.alibaba.fastjson2.JSON;
import com.dfg.java_template.common.constant.HttpStatus;
import com.dfg.java_template.framework.util.servlet.ServletUtils;
import com.dfg.java_template.framework.util.string.StringUtils;
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
import java.util.HashMap;
import java.util.Map;

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

    private static final String AUTHENTICATION_EXCEPTION = "请求访问：{requestUrl}，认证失败，无法访问系统资源";

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
            throws IOException {
        Map<String, Object> requestUrl = new HashMap<>();
        requestUrl.put("requestUrl", request.getRequestURI());
        int code = HttpStatus.UNAUTHORIZED;
        String msg = StringUtils.replaceBraces(AUTHENTICATION_EXCEPTION, requestUrl);

        log.error("\n认证失败\n路径: {} \n异常类型: {}\n原因: {}\n",
                request.getRequestURI(),
                e.getClass().getSimpleName(),
                e.getMessage());

        ServletUtils.renderString(response, JSON.toJSONString(new AjaxResult(code, msg, requestUrl)));
    }


}
