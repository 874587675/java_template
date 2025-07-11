package com.dfg.java_template.framework.pay.wechat.config;

import com.wechat.pay.java.core.RSAPublicKeyConfig;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "wxpay")
@Data
public class WxPayConfig {
    private PayParams payparams;
//    //SpringBoot的Bean默认是单例的
//    @Bean
//    public RSAAutoCertificateConfig rSAAutoCertificateConfig() {
//        return new RSAAutoCertificateConfig.Builder()
//                //商户号
//                .merchantId(payparams.getMerchantId())
//                //商户API私钥路径
//                .privateKeyFromPath(payparams.getPrivateKeyPath())
//                //商户证书序列号
//                .merchantSerialNumber(payparams.getMerchantSerialNumber())
//                //商户API3密钥
//                .apiV3Key(payparams.getApiV3Key())
//                .build();
//    }

    @Bean
    public RSAPublicKeyConfig rSAPublicKeyConfig() {
        return new RSAPublicKeyConfig.Builder()
                .merchantId(payparams.getMerchantId()) //微信支付的商户号
                .privateKeyFromPath(payparams.getPrivateKeyPath()) // 商户API证书私钥的存放路径
                .publicKeyFromPath(payparams.getPublicCertPath()) //微信支付公钥的存放路径
                .publicKeyId(payparams.getPublicId()) //微信支付公钥ID
                .merchantSerialNumber(payparams.getMerchantSerialNumber()) //商户API证书序列号
                .apiV3Key(payparams.getApiV3Key()) //APIv3密钥
                .build();
    }

    

    @Data
    public static class PayParams {
        private String MerchantId;
        private String AppId;
        private String AppSecret;
        private String PrivateKeyPath;
        private String PrivateCertPath;
        private String PublicCertPath;
        private String PublicId;
        private String MerchantSerialNumber;
        private String ApiV3Key;
        private String NotifyUrl;
        private String ReturnUrl;
    }
}
