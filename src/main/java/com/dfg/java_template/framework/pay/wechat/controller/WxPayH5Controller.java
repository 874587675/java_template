package com.dfg.java_template.framework.pay.wechat.controller;


import com.dfg.java_template.framework.pay.wechat.service.impl.WxPayH5Service;
import com.dfg.java_template.framework.pay.wechat.dto.WeChatH5PayDTO;
import com.dfg.java_template.common.web.R;
import com.wechat.pay.java.service.payments.model.Transaction;
import com.wechat.pay.java.service.refund.model.Refund;
import com.wechat.pay.java.service.refund.model.RefundNotification;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/wxpay/pay")
@Api(tags = "微信支付管理模块")
public class WxPayH5Controller {
    @Resource
    private WxPayH5Service wxPayH5Service;

    @PostMapping("/h5/wxPay")
    @ApiOperation("微信H5环境支付订单")
    public R<Map<String, String>> wxPay(@RequestBody WeChatH5PayDTO weChatH5PayDTO) throws Exception {
        return R.ok(wxPayH5Service.wxPay(weChatH5PayDTO));
    }

    @GetMapping("/h5/queryOrderByTransactionId")
    @ApiOperation("通过微信订单交易号查询H5订单")
    public R<Transaction> queryOrderByTransactionId(@RequestParam String transactionId) throws Exception {
        return R.ok(wxPayH5Service.queryOrderByTransactionId(transactionId));
    }

    @GetMapping("/h5/queryOrderByOutTradeNo")
    @ApiOperation("通过商户订单号查询H5订单")
    public R<Transaction> queryOrderByOutTradeNo(@RequestParam String outTradeNo) throws Exception {
        return R.ok(wxPayH5Service.queryOrderByOutTradeNo(outTradeNo));
    }

    @GetMapping("/h5/closeByOutTradeNo")
    @ApiOperation("通过商户订单号关闭微信H5订单")
    public R<Boolean> closeByOutTradeNo(@RequestParam String outTradeNo) {
        return R.ok(wxPayH5Service.closeByOutTradeNo(outTradeNo));
    }

    @GetMapping("/h5/refundsByOutTradeNo")
    @ApiOperation("商户订单号H5申请退款")
    public R<Boolean> refundsByOutTradeNo(@RequestParam String outTradeNo,
                                          @RequestParam String outRefundNo,
                                          @RequestParam Integer total,
                                          @RequestParam Integer refund){
        return R.ok(wxPayH5Service.refundsByOutTradeNo(outTradeNo,outRefundNo,total,refund));
    }

    @GetMapping("/h5/refundsByTransactionId")
    @ApiOperation("微信交易订单号H5申请退款")
    public R<Boolean> refundsByTransactionId(@RequestParam String transactionId,
                                             @RequestParam String outRefundNo,
                                             @RequestParam Integer total,
                                             @RequestParam Integer refund){
        return R.ok(wxPayH5Service.refundsByTransactionId(transactionId,outRefundNo,total,refund));
    }
    @GetMapping("/h5/refundsQueryByOutRefundNo")
    @ApiOperation("查询微信H5退款单")
    public R<Refund> refundsQueryByOutRefundNo(@RequestParam String outRefundNo) {
        return R.ok(wxPayH5Service.refundsQueryByOutRefundNo(outRefundNo));
    }

    @PostMapping("/h5/notify/wxPay")
    @ApiOperation("微信支付回调H5通知")
    public R<Transaction> notify(HttpServletRequest request) {
        return R.ok(wxPayH5Service.notify(request));
    }

    @PostMapping("/h5/refund/wxPay")
    @ApiOperation("微信退款回调H5通知")
    public R<RefundNotification> refundNotify(HttpServletRequest request) {
        return R.ok(wxPayH5Service.refundNotify(request));
    }
}
