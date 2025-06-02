package com.dfg.java_template.framework.wechatplugin.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: RuoYi-Vue-fast
 * @ClassName WeChatConfig
 * @description:
 * @author: zgc
 * @date: 2025-04-02 21:32
 * @Version 1.0
 **/
@Component
@ConfigurationProperties(prefix = "wechat")
@Data
public class WeChatConfig {
    private MiniApp miniApp;
    private Mp mp;
    private Open open;

    @Data
    public static class MiniApp {
        private String appId;
        private String appSecret;
    }

    @Data
    public static class Mp {
        private String appId;
        private String appSecret;
    }
    
    @Data
    public static class Open {
        private String appId;
        private String appSecret;
    }
    
}
