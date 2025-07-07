package com.dfg.java_template.framework.pay.wechat.service;

import com.dfg.java_template.framework.pay.wechat.param.response.CancelTransferBillResponse;
import com.dfg.java_template.framework.pay.wechat.param.response.GetTransferBillResponse;
import com.dfg.java_template.framework.pay.wechat.param.response.TransferBillResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

public interface WxTransferBillFactory {
    /**
     * 微信商家转账
     * @param outBillNo 商户转账单号
     * @param openId openId
     * @param amount 金额
     * @return 
     */
    TransferBillResponse transfer(String outBillNo, String openId, BigDecimal amount);

    /**
     * 撤销微信转账
     *
     * @param outBillNo 商户转账单号
     * @return
     */
    CancelTransferBillResponse cancelTransfer(String outBillNo);

    /**
     * 根据商户单号查询微信转账
     * @param outBillNo 商户转账单号
     * @return
     */
    GetTransferBillResponse getTransferBillByOutNo(String outBillNo);

    /**
     * 根据微信单号查询微信转账
     * @param transferBillNo 微信转账单号
     * @return
     */
    GetTransferBillResponse getTransferBillByNo(String transferBillNo);

    /**
     * 微信转账回调
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return
     */
    GetTransferBillResponse notify(HttpServletRequest request, HttpServletResponse response);
}
