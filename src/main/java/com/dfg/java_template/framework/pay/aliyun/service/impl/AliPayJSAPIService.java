package com.dfg.java_template.framework.pay.aliyun.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.diagnosis.DiagnosisUtils;
import com.alipay.api.domain.*;
import com.alipay.api.request.*;
import com.alipay.api.response.*;
import com.dfg.java_template.common.exception.ServiceException;
import com.dfg.java_template.framework.pay.aliyun.config.AlipayConfigs;
import com.dfg.java_template.framework.pay.aliyun.service.AliPayJSAPIMent;
import com.dfg.java_template.framework.pay.aliyun.vo.*;
import com.dfg.java_template.framework.pay.aliyun.vo.jsapi.AliPayTradeCreateVO;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class AliPayJSAPIService implements AliPayJSAPIMent {
    @Resource
    private AlipayConfigs aliPayConfigs;

    @Override
    public String pay(AliPayTradeCreateVO aliPayTradeCreateVO) throws AlipayApiException {
        AlipayClient aliPayClient = new DefaultAlipayClient(aliPayConfigs.getAlipayConfig());
        // 设置支付请求模型
        AlipayTradeCreateModel model = new AlipayTradeCreateModel();
        model.setOutTradeNo(aliPayTradeCreateVO.getOutTradeNo());    // 商户订单号 必选
        model.setTotalAmount(String.valueOf(aliPayTradeCreateVO.getTotalAmount()));    // 订单金额 必选
        model.setSubject(aliPayTradeCreateVO.getSubject());   // 订单标题 必选
        model.setProductCode(aliPayConfigs.getPayParams().getProductCode());   // 销售产品码 必选
        model.setOpAppId(aliPayConfigs.getPayParams().getAppId()); // 商户应用ID 必选
        model.setBuyerOpenId(aliPayTradeCreateVO.getBuyerOpenId());  // 买家支付宝用户ID 必选

        AlipayTradeCreateRequest request = new AlipayTradeCreateRequest();
        request.setReturnUrl(aliPayConfigs.getPayParams().getReturnUrl());
        request.setNotifyUrl(aliPayConfigs.getPayParams().getNotifyUrl());
        request.setBizModel(model);
        AlipayTradeCreateResponse response = aliPayClient.pageExecute(request);
        log.info("支付支付宝订单响应信息:{}", response.getBody());
        if (response.isSuccess()) {
            log.info("支付订单接口调用成功");
            return response.getBody();  // 返回支付页面 HTML
        } else {
            log.info("支付订单接口调用失败");
            String diagnosisUrl = DiagnosisUtils.getDiagnosisUrl(response);
            log.info("支付支付宝订单诊断信息:{}", diagnosisUrl);
            throw new ServiceException("支付宝支付请求操作失败");
        }
    }

    @Override
    public String cancel(AliPayTradeCancelVO aliPayTradeCloseVO) throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient(aliPayConfigs.getAlipayConfig());
        
        AlipayTradeCancelModel model = new AlipayTradeCancelModel();
        model.setOutTradeNo(aliPayTradeCloseVO.getOutTradeNo());
        model.setTradeNo(aliPayTradeCloseVO.getTradeNo());

        AlipayTradeCancelRequest request = new AlipayTradeCancelRequest();
        request.setBizModel(model);

        AlipayTradeCancelResponse response = alipayClient.execute(request);
        log.info("取消支付宝订单响应信息:{}", response.getBody());
        if (response.isSuccess()) {
            log.info("取消订单接口调用成功");
            return response.getBody();  // 返回支付页面 HTML
        } else {
            log.info("取消订单接口调用失败");
            String diagnosisUrl = DiagnosisUtils.getDiagnosisUrl(response);
            log.info("取消支付宝订单诊断信息:{}", diagnosisUrl);
            throw new ServiceException("支付宝取消请求操作失败");
        }
    }

    @Override
    public String close(AliPayTradeCloseVO aliPayTradeCloseVO) throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient(aliPayConfigs.getAlipayConfig());
        AlipayTradeCloseRequest request = new AlipayTradeCloseRequest();
        AlipayTradeCloseModel model = new AlipayTradeCloseModel();
        //下面两种起码二选一、若同时存在则优先取trade_no
        model.setTradeNo(aliPayTradeCloseVO.getOutTradeNo());  //商户订单号
        model.setOutTradeNo(aliPayTradeCloseVO.getTradeNo());  // 支付宝交易流水号
        request.setBizModel(model);
        AlipayTradeCloseResponse response = alipayClient.execute(request);
        log.info("关闭支付宝订单响应信息:{}", response.getBody());
        if (response.isSuccess()) {
            log.info("关闭订单接口调用成功");
            return response.getBody();
        } else {
            log.info("关闭订单接口调用失败");
            String diagnosisUrl = DiagnosisUtils.getDiagnosisUrl(response);
            log.info("关闭支付宝订单诊断信息:{}", diagnosisUrl);
            throw new ServiceException("关闭支付宝订单操作失败");
        }
    }

    @Override
    public String query(AliPayTradeQueryVO aliPayTradeQueryVO) throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient(aliPayConfigs.getAlipayConfig());
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        AlipayTradeQueryModel model = new AlipayTradeQueryModel();
        //下面两种起码二选一、若同时存在则优先取trade_no
        model.setTradeNo(aliPayTradeQueryVO.getOutTradeNo());  //商户订单号
        model.setOutTradeNo(aliPayTradeQueryVO.getTradeNo());  // 支付宝交易流水号
        request.setBizModel(model);
        AlipayTradeQueryResponse response = alipayClient.execute(request);
        log.info("查询支付宝订单响应信息:{}", response.getBody());
        if (response.isSuccess()) {
            log.info("查询订单接口调用成功");
            return response.getBody();
        } else {
            log.info("查询订单接口调用失败");
            String diagnosisUrl = DiagnosisUtils.getDiagnosisUrl(response);
            log.info("查询支付宝订单诊断信息:{}", diagnosisUrl);
            throw new ServiceException("查询支付宝订单操作失败");
        }
    }

    @Override
    public String refund(AliPayTradeRefundVO aliPayTradeRefundVO) throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient(aliPayConfigs.getAlipayConfig());
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        AlipayTradeRefundModel model = new AlipayTradeRefundModel();
        model.setTradeNo(aliPayTradeRefundVO.getOutTradeNo());  //商户订单号
        model.setOutTradeNo(aliPayTradeRefundVO.getTradeNo());  // 支付宝交易流水号
        model.setRefundAmount(aliPayTradeRefundVO.getRefundAmount()); //退款金额
        //若出现部分退款的情况，则参数out_request_no必填
        request.setBizModel(model);
        AlipayTradeRefundResponse response = alipayClient.execute(request);
        log.info("退款支付宝订单响应信息:{}", response.getBody());
        if (response.isSuccess()) {
            log.info("退款订单接口调用成功");
            return response.getBody();
        } else {
            log.info("退款订单接口调用失败");
            String diagnosisUrl = DiagnosisUtils.getDiagnosisUrl(response);
            log.info("退款支付宝订单诊断信息:{}", diagnosisUrl);
            throw new ServiceException("退款支付宝订单操作失败");
        }
    }

    @Override
    public String refundQuery(AliPayTradeRefundQueryVO aliPayTradeRefundQueryVO) throws AlipayApiException {
        // 初始化SDK
        AlipayClient alipayClient = new DefaultAlipayClient(aliPayConfigs.getAlipayConfig());
        // 构造请求参数以调用接口
        AlipayTradeFastpayRefundQueryRequest request = new AlipayTradeFastpayRefundQueryRequest();
        AlipayTradeFastpayRefundQueryModel model = new AlipayTradeFastpayRefundQueryModel();
        // 设置支付宝交易号
        model.setTradeNo(aliPayTradeRefundQueryVO.getTradeNo());
        // 设置商户订单号
        model.setOutTradeNo(aliPayTradeRefundQueryVO.getOutTradeNo());
        // 设置退款请求号
        model.setOutRequestNo(aliPayTradeRefundQueryVO.getOutRequestNo()); //如果在退款请求时未传入，则该值为创建交易时的商户订单号。
        // 设置查询选项
        List<String> queryOptions = new ArrayList<String>();
        queryOptions.add("refund_detail_item_list");
        model.setQueryOptions(queryOptions);
        request.setBizModel(model);
        AlipayTradeFastpayRefundQueryResponse response = alipayClient.execute(request);
        log.info("查询支付宝退款订单响应信息:{}", response.getBody());
        if (response.isSuccess()) {
            log.info("退款订单接口调用成功");
            return response.getBody();
        } else {
            log.info("退款订单接口调用失败");
            String diagnosisUrl = DiagnosisUtils.getDiagnosisUrl(response);
            log.info("查询支付宝退款订单诊断信息:{}", diagnosisUrl);
            throw new ServiceException("查询支付宝退款订单操作失败");
        }
    }

    @Override
    public String queryDownloadBillUrl(AliPayDataBillDownloadVO aliPayDataBillDownloadVO) throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient(aliPayConfigs.getAlipayConfig());
        AlipayDataDataserviceBillDownloadurlQueryRequest request = new AlipayDataDataserviceBillDownloadurlQueryRequest();
        AlipayDataDataserviceBillDownloadurlQueryModel model = new AlipayDataDataserviceBillDownloadurlQueryModel();
        model.setBillType(aliPayDataBillDownloadVO.getBillType());
        model.setBillDate(aliPayDataBillDownloadVO.getBillDate());
        request.setBizModel(model);
        AlipayDataDataserviceBillDownloadurlQueryResponse response = alipayClient.execute(request);
        log.info("下载支付宝账单响应信息:{}", response.getBody());
        if (response.isSuccess()) {
            log.info("下载支付宝账单接口调用成功");
            return response.getBody();  // 获取账单下载URL
        } else {
            log.info("下载支付宝账单接口调用失败");
            String diagnosisUrl = DiagnosisUtils.getDiagnosisUrl(response);
            log.info("下载支付宝账单诊断信息:{}", diagnosisUrl);
            throw new ServiceException("下载支付宝账单操作失败");
        }
    }

    @Override
    public String returnUrl(HttpServletRequest request, HttpServletResponse response) {
        log.info("进入回调");
        String orderNo = request.getParameter("out_trade_no");
        String tradeNo = request.getParameter("trade_no");
        String totalAmount = request.getParameter("total_amount");

        // 处理支付成功后的操作
        // 例如，更新订单状态、发送支付成功邮件等
        log.info("订单号：" + orderNo + " 支付成功，支付金额：" + totalAmount + " 支付宝交易号：" + tradeNo);
        return "支付回调成功";
    }
}
