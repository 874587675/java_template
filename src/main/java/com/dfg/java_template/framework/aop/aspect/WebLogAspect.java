package com.dfg.java_template.framework.aop.aspect;

import cn.hutool.core.lang.generator.SnowflakeGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author zgc
 */
@Aspect
@Component
@Slf4j
public class WebLogAspect {
    
    
    @Pointcut("execution(public * com.dfg.java_template.business.controller.*.*.*(..))")
    public void controllerWebLog() {
    }

    //环绕通知
    @Around("controllerWebLog()")
    public Object doBefore(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        
        // 生成唯一请求ID并放入MDC
        String traceId = String.valueOf(new SnowflakeGenerator().next());
        MDC.put("LOG_ID", traceId);  // LOG_ID将自动出现在日志中
        
        //通过ThreadLocal机制实现的
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        if (attributes == null) {
            return proceedingJoinPoint.proceed(); // 如果没有请求上下文，直接执行方法
        }
        
        long startTime = System.currentTimeMillis();    //接口开始的时间戳
        HttpServletRequest request = attributes.getRequest();
        log.info("《================================================================请求开始================================================================》");
        log.info("请求的URL为:{}", request.getRequestURL());
        log.info("请求的HTTP方式为:{}", request.getMethod());
        log.info("请求客户端（代理）的IP为:{}", request.getRemoteAddr());
        log.info("请求的CLASS_METHOD方法名:{}.{}", proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName());
        log.info("请求的参数分别是:{}", Arrays.toString(proceedingJoinPoint.getArgs()));
        log.info("请求头token:{}", request.getHeader("Access-Token"));
        log.info("请求头userId:{}", request.getHeader("userId"));
        log.info("请求开始时间: {}", formatTime(startTime));
        // 执行目标方法（相当于原方法执行）
        Object result = proceedingJoinPoint.proceed();
        // 记录返回结果
        long endTime = System.currentTimeMillis();  //接口结束的时间戳
        log.info("返回响应为:{}", new ObjectMapper().writeValueAsString(result));
        log.info("请求结束时间:{}", formatTime(startTime));
        log.info("《================================================================请求结束================================================================》");
        double executionTime = (double) (endTime - startTime);   //接口执行的时间
        log.info("接口执行时间:{}s", executionTime / 1000);
        // 性能警告
        if (executionTime > 1000 ) {
            log.warn("性能警告:此接口执行时间超过1秒，请检查优化！");
        } else if (executionTime > 500) {
            log.warn("性能提示:此接口执行时间超过500毫秒");
        }
        return result;
    }

    // 格式化时间
    private String formatTime(long timestamp) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(timestamp));
    }
}
