package com.dfg.java_template.framework.wechatplugin.config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class WxMaSelfConfig {
    @Resource
    private WeChatConfig weChatConfig;

    @Bean
    public WxMaService wxMaService() {
        WxMaDefaultConfigImpl wxMaDefaultConfig = new WxMaDefaultConfigImpl();
        wxMaDefaultConfig.setAppid(weChatConfig.getMiniApp().getAppId());
        wxMaDefaultConfig.setSecret(weChatConfig.getMiniApp().getAppSecret());

        WxMaService wxMaService = new WxMaServiceImpl();
        wxMaService.setWxMaConfig(wxMaDefaultConfig);
        return wxMaService;
    }

}
