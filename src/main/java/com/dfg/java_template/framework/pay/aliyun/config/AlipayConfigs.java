package com.dfg.java_template.framework.pay.aliyun.config;

import com.alipay.api.AlipayConfig;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "alipay")
@Data
public class AlipayConfigs {
    private PayParams payParams;
    
    @Bean
    public AlipayConfig getAlipayConfig() {
        AlipayConfig alipayConfig = new AlipayConfig(); //支付宝配置
        alipayConfig.setAppId(payParams.getAppId());    //应用ID
        alipayConfig.setPrivateKey(payParams.getMerchantPrivateKey());  //商户私钥
        alipayConfig.setAlipayPublicKey(payParams.getAlipayPublicKey());    //支付宝公钥
        alipayConfig.setServerUrl(payParams.getGatewayUrl());   //支付宝网关
        alipayConfig.setSignType(payParams.getSignType());  //签名方式
        alipayConfig.setCharset(payParams.getCharset());    //字符编码格式
        alipayConfig.setFormat(payParams.getFormat());  //格式
        return alipayConfig;
    }
    
    @Data
    public static class PayParams {
        private String AppId;   
        private String MerchantPrivateKey;
        private String AlipayPublicKey;
        private String GatewayUrl;
        private String NotifyUrl;
        private String ReturnUrl;
        private String SignType;
        private String Charset;
        private String Format;
        private String Version;
        private String ProductCode;
    }

}
