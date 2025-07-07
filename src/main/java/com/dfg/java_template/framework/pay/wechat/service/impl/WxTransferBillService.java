package com.dfg.java_template.framework.pay.wechat.service.impl;

import cn.hutool.core.io.IoUtil;
import com.alibaba.fastjson.JSON;
import com.dfg.java_template.common.exception.ServiceException;
import com.dfg.java_template.framework.pay.wechat.common.WxPayCommon;
import com.dfg.java_template.framework.pay.wechat.config.WxPayConfig;
import com.dfg.java_template.framework.pay.wechat.param.request.CancelTransferBillsRequest;
import com.dfg.java_template.framework.pay.wechat.param.request.GetTransferBillByNoRequest;
import com.dfg.java_template.framework.pay.wechat.param.request.GetTransferBillByOutNoRequest;
import com.dfg.java_template.framework.pay.wechat.param.request.TransferBillsRequest;
import com.dfg.java_template.framework.pay.wechat.param.response.CancelTransferBillResponse;
import com.dfg.java_template.framework.pay.wechat.param.response.GetTransferBillResponse;
import com.dfg.java_template.framework.pay.wechat.param.response.TransferBillResponse;
import com.dfg.java_template.framework.pay.wechat.service.WxTransferBillFactory;
import com.dfg.java_template.framework.pay.wechat.service.base.TransferBillService;
import com.wechat.pay.java.core.RSAPublicKeyConfig;
import com.wechat.pay.java.core.notification.NotificationParser;
import com.wechat.pay.java.core.notification.RequestParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
public class WxTransferBillService implements WxTransferBillFactory {
    @Resource
    private WxPayConfig wxPayConfig;
    @Resource
    private RSAPublicKeyConfig config;

    @Override
    public TransferBillResponse transfer(String outBillNo, String openId, BigDecimal amount) {

        TransferBillService transferBillService = new TransferBillService.Builder().config(config).build();
        // 构建请求对象
        TransferBillsRequest request = new TransferBillsRequest();
        request.setAppId(wxPayConfig.getPayparams().getAppId());
        request.setOutBillNo(outBillNo);
        request.setTransferSceneId("1005"); //转账场景ID 1005 
        request.setOpenId(openId);
        request.setTransferAmount(amount.multiply(BigDecimal.valueOf(100)).intValue());
        request.setTransferRemark("XXXX");

        // 构造转账场景报备信息
        List<TransferBillsRequest.TransferSceneReportInfo> reportInfos = List.of(
                new TransferBillsRequest.TransferSceneReportInfo("岗位类型", "普通用户"),
                new TransferBillsRequest.TransferSceneReportInfo("报酬说明", "佣金发放")
        );
        request.setTransferSceneReportInfos(reportInfos);
        try {
            TransferBillResponse transferBillResponse = transferBillService.transfer(request);
            log.info("商家转账响应:{}",transferBillResponse);
            return transferBillResponse;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException("商家转账异常");
        }
    }

    @Override
    public CancelTransferBillResponse cancelTransfer(String outBillNo) {
        TransferBillService transferBillService = new TransferBillService.Builder().config(config).build();
        try {
            CancelTransferBillsRequest cancelTransferBillsRequest = new CancelTransferBillsRequest();
            cancelTransferBillsRequest.setOutBillNo(outBillNo);
            
            CancelTransferBillResponse cancelTransferBillResponse = transferBillService.cancelTransfer(cancelTransferBillsRequest);
            log.info("商家撤销转账响应:{}",cancelTransferBillResponse);
            return cancelTransferBillResponse;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException("撤销转账异常");
        }
    }

    @Override
    public GetTransferBillResponse getTransferBillByOutNo(String outBillNo) {
        TransferBillService transferBillService = new TransferBillService.Builder().config(config).build();
        try {
            GetTransferBillByOutNoRequest getTransferBillByOutNoRequest = new GetTransferBillByOutNoRequest();
            getTransferBillByOutNoRequest.setOutBillNo(outBillNo);
            GetTransferBillResponse getTransferBillResponse = transferBillService.getTransferBillByOutNo(getTransferBillByOutNoRequest);
            log.info("商户单号查询转账单响应:{}",getTransferBillResponse);
            return getTransferBillResponse;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException("商户单号查询转账单异常");
        }
    }

    @Override
    public GetTransferBillResponse getTransferBillByNo(String transferBillNo) {
        TransferBillService transferBillService = new TransferBillService.Builder().config(config).build();
        try {
            GetTransferBillByNoRequest request = new GetTransferBillByNoRequest(transferBillNo);
            GetTransferBillResponse getTransferBillResponse = transferBillService.getTransferBillByNo(request);
            log.info("微信单号查询转账单响应:{}", getTransferBillResponse);
            return getTransferBillResponse;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException("微信单号查询转账单异常");
        }
    }

    @Override
    public GetTransferBillResponse notify(HttpServletRequest request, HttpServletResponse response) {
        log.info("商家转账通知回调-开始");
        try {
            String body = IoUtil.getUtf8Reader(request.getInputStream()).readLine();
            RequestParam requestParam = new RequestParam.Builder()
                    .serialNumber(request.getHeader(WxPayCommon.WECHATPAY_SERIAL))
                    .nonce(request.getHeader(WxPayCommon.WECHATPAY_NONCE))
                    .signature(request.getHeader(WxPayCommon.WECHATPAY_SIGNATURE))
                    .timestamp(request.getHeader(WxPayCommon.WECHATPAY_TIMESTAMP))
                    .signType(request.getHeader(WxPayCommon.WECHATPAY_SIGN_TYPE))
                    .body(body)
                    .build();
            NotificationParser parser = new NotificationParser(config);
            // 以商家转账通知回调为例，验签、解密并转换成 GetTransferBillResponse
            GetTransferBillResponse getTransferBillResponse = parser.parse(requestParam, GetTransferBillResponse.class);
            log.info("商家转账通知回调-结束：{}", JSON.toJSONString(getTransferBillResponse));
            return getTransferBillResponse;
        }catch (Exception ex) {
            ex.printStackTrace();
            throw new ServiceException("商家转账通知回调-异常");
        }
    }
}
