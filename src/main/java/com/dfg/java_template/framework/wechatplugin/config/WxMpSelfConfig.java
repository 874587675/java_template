package com.dfg.java_template.framework.wechatplugin.config;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
@Configuration
public class WxMpSelfConfig {
        @Resource
        private WeChatConfig weChatConfig;

        @Bean
        public WxMpService wxMpService() {
            WxMpDefaultConfigImpl wxMpDefaultConfig = new WxMpDefaultConfigImpl();
            wxMpDefaultConfig.setAppId(weChatConfig.getMp().getAppId());
            wxMpDefaultConfig.setSecret(weChatConfig.getMp().getAppSecret());

            WxMpServiceImpl wxMpService = new WxMpServiceImpl();
            wxMpService.setWxMpConfigStorage(wxMpDefaultConfig);
            return wxMpService;
        }
}
