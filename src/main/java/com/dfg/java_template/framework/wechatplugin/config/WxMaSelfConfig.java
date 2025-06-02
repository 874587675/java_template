package com.dfg.java_template.framework.wechatplugin.config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @program: RuoYi-Vue-fast
 * @ClassName WxMaConfig
 * @description:
 * @author: zgc
 * @date: 2025-04-02 21:12
 * @Version 1.0
 **/
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
