package com.dfg.java_template.framework.pay.wechat.common;


import com.dfg.java_template.framework.pay.wechat.dto.WeChatJsapiPayDTO;

/**
 * @ClassName:WxPayCommon
 * @description:
 * @author: zgc
 **/
public class WxPayCommon {
    
    public static final String WECHATPAY_SERIAL = "Wechatpay-Serial";
    public static final String WECHATPAY_NONCE = "Wechatpay-Nonce";
    public static final String WECHATPAY_SIGNATURE = "Wechatpay-Signature";
    public static final String WECHATPAY_TIMESTAMP = "Wechatpay-Timestamp";
    public static final String WECHATPAY_SIGN_TYPE = "Wechatpay-Signature-Type";
    
    public static String getWxPayCacheKey(WeChatJsapiPayDTO weChatJsapiPayDTO) {
        return weChatJsapiPayDTO.getPayer().getOpenid() + "/" + weChatJsapiPayDTO.getOutTradeNo();
    }
}
