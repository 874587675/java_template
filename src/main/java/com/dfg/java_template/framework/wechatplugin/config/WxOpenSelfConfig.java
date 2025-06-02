package com.dfg.java_template.framework.wechatplugin.config;

import me.chanjar.weixin.open.api.WxOpenConfigStorage;
import me.chanjar.weixin.open.api.impl.WxOpenInMemoryConfigStorage;
import me.chanjar.weixin.open.api.impl.WxOpenOAuth2ServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class WxOpenSelfConfig {
    @Resource
    private WeChatConfig weChatConfig;

    @Bean
    public WxOpenConfigStorage wxOpenConfigStorage() {
        WxOpenInMemoryConfigStorage storage = new WxOpenInMemoryConfigStorage();
        storage.setComponentAppId(weChatConfig.getOpen().getAppId());
        storage.setComponentAppSecret(weChatConfig.getOpen().getAppSecret());
        return storage;
    }

    
    @Bean
    public WxOpenOAuth2ServiceImpl wxOpenOAuth2ServiceImpl(WxOpenConfigStorage configStorage) {
        return new WxOpenOAuth2ServiceImpl(weChatConfig.getOpen().getAppId(), weChatConfig.getOpen().getAppSecret(), configStorage);
    }
}
