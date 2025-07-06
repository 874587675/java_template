package com.dfg.java_template.framework.pay.wechat.service.impl;

import cn.hutool.json.JSONUtil;
import com.dfg.java_template.common.exception.ServiceException;
import com.dfg.java_template.framework.pay.wechat.config.WxPayConfig;
import com.dfg.java_template.framework.pay.wechat.param.request.TransferBillsRequest;
import com.dfg.java_template.framework.pay.wechat.param.response.TransferBillResponse;
import com.wechat.pay.java.core.RSAPublicKeyConfig;
import com.wechat.pay.java.core.http.*;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
public class WxTransferBillService {
    @Resource
    private WxPayConfig wxPayConfig;
    public String transfer(String outBillNo, String openId, BigDecimal amount) {
        RSAPublicKeyConfig config = wxPayConfig.rSAPublicKeyConfig();

        OkHttpClient okHttpClient = new OkHttpClient();
        HttpClient httpClient = new DefaultHttpClientBuilder()
                .config(config)
                .okHttpClient(okHttpClient)
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.addHeader("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.addHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        headers.addHeader("Wechatpay-Serial", "PUB_KEY_ID_" + wxPayConfig.getPayparams().getPublicId());
        
        
        // 构建请求对象
        TransferBillsRequest request = new TransferBillsRequest();
        request.setAppId(wxPayConfig.getPayparams().getAppId());
        request.setOutBillNo(outBillNo);
        request.setTransferSceneId("1005"); //转账场景ID 1005 
        request.setOpenId(openId);
        request.setTransferAmount(amount.multiply(BigDecimal.valueOf(100)).intValue());
        request.setTransferRemark("特客星球");

        // 构造转账场景报备信息
        List<TransferBillsRequest.TransferSceneReportInfo> reportInfos = List.of(
                new TransferBillsRequest.TransferSceneReportInfo("岗位类型", "普通用户"),
                new TransferBillsRequest.TransferSceneReportInfo("报酬说明", "佣金发放")
        );
        request.setTransferSceneReportInfos(reportInfos);

        // 序列化请求体
        JsonRequestBody body = new JsonRequestBody.Builder()
                .body(JSONUtil.toJsonStr(request))
                .build();

        HttpRequest httpRequest = new HttpRequest.Builder()
                .httpMethod(HttpMethod.POST)
                .url("https://api.mch.weixin.qq.com/v3/fund-app/mch-transfer/transfer-bills")
                .headers(headers)
                .body(body)
                .build();

        try {
            HttpResponse<TransferBillResponse> response = httpClient.execute(httpRequest, TransferBillResponse.class);
            TransferBillResponse responseBody = response.getServiceResponse();
            log.info("发起转账返回：{}", JSONUtil.toJsonStr(responseBody));
            return responseBody.getPackageInfo();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException("提现异常");
        }
    }

}
