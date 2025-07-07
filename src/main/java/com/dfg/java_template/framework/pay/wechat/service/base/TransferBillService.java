package com.dfg.java_template.framework.pay.wechat.service.base;

import com.dfg.java_template.framework.pay.wechat.param.request.CancelTransferBillsRequest;
import com.dfg.java_template.framework.pay.wechat.param.request.GetTransferBillByNoRequest;
import com.dfg.java_template.framework.pay.wechat.param.request.GetTransferBillByOutNoRequest;
import com.dfg.java_template.framework.pay.wechat.param.request.TransferBillsRequest;
import com.dfg.java_template.framework.pay.wechat.param.response.CancelTransferBillResponse;
import com.dfg.java_template.framework.pay.wechat.param.response.GetTransferBillResponse;
import com.dfg.java_template.framework.pay.wechat.param.response.TransferBillResponse;
import com.wechat.pay.java.core.Config;
import com.wechat.pay.java.core.http.*;
import com.wechat.pay.java.core.util.GsonUtil;
import org.springframework.http.MediaType;

import java.util.Objects;

public class TransferBillService {
    private final HttpClient httpClient;
    private final HostName hostName;

    private TransferBillService(HttpClient httpClient, HostName hostName) {
        this.httpClient = (HttpClient) Objects.requireNonNull(httpClient);
        this.hostName = hostName;
    }

    public TransferBillResponse transfer(TransferBillsRequest transferBillsRequest) {
        String requestPath = "https://api.mch.weixin.qq.com/v3/fund-app/mch-transfer/transfer-bills";

        if (this.hostName != null) {
            requestPath = requestPath.replaceFirst(HostName.API.getValue(), this.hostName.getValue());
        }

        HttpHeaders headers = new HttpHeaders();
        headers.addHeader("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.addHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE);

        HttpRequest httpRequest = (new HttpRequest.Builder()).httpMethod(HttpMethod.POST).url(requestPath).headers(headers).body(this.createRequestBody(transferBillsRequest)).build();
        HttpResponse<TransferBillResponse> httpResponse = this.httpClient.execute(httpRequest, TransferBillResponse.class);
        return httpResponse.getServiceResponse();
    }
    
    public CancelTransferBillResponse cancelTransfer(CancelTransferBillsRequest cancelTransferBillsRequest) {
        String requestPath = "https://api.mch.weixin.qq.com/v3/fund-app/mch-transfer/transfer-bills/out-bill-no/{out_bill_no}/cancel";
        requestPath = requestPath.replace("{out_bill_no}", UrlEncoder.urlEncode(cancelTransferBillsRequest.getOutBillNo()));
        if (this.hostName != null) {
            requestPath = requestPath.replaceFirst(HostName.API.getValue(), this.hostName.getValue());
        }

        HttpHeaders headers = new HttpHeaders();
        headers.addHeader("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.addHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE);

        HttpRequest httpRequest = (new HttpRequest.Builder()).httpMethod(HttpMethod.POST).url(requestPath).headers(headers).body(this.createRequestBody(cancelTransferBillsRequest)).build();
        HttpResponse<CancelTransferBillResponse> httpResponse = this.httpClient.execute(httpRequest, CancelTransferBillResponse.class);
        return httpResponse.getServiceResponse();
    }
    
    public GetTransferBillResponse getTransferBillByOutNo(GetTransferBillByOutNoRequest getTransferBillByOutNoRequest) { 
        String requestPath = "https://api.mch.weixin.qq.com/v3/fund-app/mch-transfer/transfer-bills/out-bill-no/{out_bill_no}";
        requestPath = requestPath.replace("{out_bill_no}", UrlEncoder.urlEncode(getTransferBillByOutNoRequest.getOutBillNo()));
        if (this.hostName != null) {
            requestPath = requestPath.replaceFirst(HostName.API.getValue(), this.hostName.getValue());
        }

        HttpHeaders headers = new HttpHeaders();
        headers.addHeader("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.addHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE);

        HttpRequest httpRequest = (new HttpRequest.Builder()).httpMethod(HttpMethod.GET).url(requestPath).headers(headers).build();
        HttpResponse<GetTransferBillResponse> httpResponse = this.httpClient.execute(httpRequest, GetTransferBillResponse.class);
        return httpResponse.getServiceResponse();
    }

    public GetTransferBillResponse getTransferBillByNo(GetTransferBillByNoRequest getTransferBillByNoRequest) {
        String requestPath = "https://api.mch.weixin.qq.com/v3/fund-app/mch-transfer/transfer-bills/transfer-bill-no/{transfer_bill_no}";
        requestPath = requestPath.replace("{out_bill_no}", UrlEncoder.urlEncode(getTransferBillByNoRequest.getTransferBillNo()));
        if (this.hostName != null) {
            requestPath = requestPath.replaceFirst(HostName.API.getValue(), this.hostName.getValue());
        }

        HttpHeaders headers = new HttpHeaders();
        headers.addHeader("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.addHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE);

        HttpRequest httpRequest = (new HttpRequest.Builder()).httpMethod(HttpMethod.GET).url(requestPath).headers(headers).build();
        HttpResponse<GetTransferBillResponse> httpResponse = this.httpClient.execute(httpRequest, GetTransferBillResponse.class);
        return httpResponse.getServiceResponse();
    }

    private RequestBody createRequestBody(Object request) {
        return (new JsonRequestBody.Builder()).body(GsonUtil.toJson(request)).build();
    }

    public static class Builder {
        private HttpClient httpClient;
        private HostName hostName;

        public TransferBillService.Builder config(Config config) {
            this.httpClient = (new DefaultHttpClientBuilder()).config(config).build();
            return this;
        }

        public TransferBillService.Builder hostName(HostName hostName) {
            this.hostName = hostName;
            return this;
        }

        public TransferBillService.Builder httpClient(HttpClient httpClient) {
            this.httpClient = httpClient;
            return this;
        }

        public TransferBillService build() {
            return new TransferBillService(this.httpClient, this.hostName);
        }
    }
}
