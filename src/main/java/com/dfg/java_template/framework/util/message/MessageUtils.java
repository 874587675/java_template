package com.dfg.java_template.framework.util.message;

import com.dfg.java_template.framework.util.spring.SpringUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * 获取i18n资源文件
 * 
 * @author zgc
 */
public class MessageUtils
{
    /**
     * 根据消息键和参数 获取消息 委托给spring messageSource
     *
     * @param message 消息键
     * @param args 参数
     * @return 获取国际化翻译值
     */
    public static String message(String message, Object... args)
    {
        MessageSource messageSource = SpringUtils.getBean(MessageSource.class);
        return messageSource.getMessage(message,  (args != null && args.length > 0) ? args : null, LocaleContextHolder.getLocale());
    }
}
