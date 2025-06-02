package com.dfg.java_template.framework.pay.aliyun.service;

import com.alipay.api.AlipayApiException;
import com.dfg.java_template.framework.pay.aliyun.vo.*;
import com.dfg.java_template.framework.pay.aliyun.vo.jsapi.AliPayTradeCreateVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @program: RuoYi-Vue-fast
 * @ClassName AliPayJSAPIMent
 * @description:
 * @author: zgc
 * @date: 2025-01-15 10:03
 * @Version 1.0
 **/
public interface AliPayJSAPIMent {
    String pay(AliPayTradeCreateVO aliPayTradeCreateVO) throws AlipayApiException;
    
    String cancel(AliPayTradeCancelVO aliPayTradeCloseVO) throws AlipayApiException;
    
    String close(AliPayTradeCloseVO aliPayTradeCloseVO) throws AlipayApiException;
    
    String query(AliPayTradeQueryVO aliPayTradeQueryVO) throws AlipayApiException;
    
    String refund(AliPayTradeRefundVO aliPayTradeRefundVO) throws AlipayApiException;
    
    String refundQuery(AliPayTradeRefundQueryVO aliPayTradeRefundQueryVO) throws AlipayApiException;
    
    String queryDownloadBillUrl(AliPayDataBillDownloadVO aliPayDataBillDownloadVO) throws AlipayApiException;
    
    String returnUrl(HttpServletRequest request, HttpServletResponse response);
    
    
}
