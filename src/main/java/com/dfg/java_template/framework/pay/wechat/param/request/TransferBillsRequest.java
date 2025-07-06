package com.dfg.java_template.framework.pay.wechat.param.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferBillsRequest {
    @JsonProperty("appid")
    @SerializedName("appid")
    private String appId;

    @JsonProperty("out_bill_no")
    @SerializedName("out_bill_no")
    private String outBillNo;

    @JsonProperty("transfer_scene_id")
    @SerializedName("transfer_scene_id")
    private String transferSceneId;

    @JsonProperty("openid")
    @SerializedName("openid")
    private String openId;

    @JsonProperty("user_name")
    @SerializedName("user_name")
    private String userName;

    @JsonProperty("transfer_amount")
    @SerializedName("transfer_amount")
    private int transferAmount;

    @JsonProperty("transfer_remark")
    @SerializedName("transfer_remark")
    private String transferRemark;

    @JsonProperty("notify_url")
    @SerializedName("notify_url")
    private String notifyUrl;

    @JsonProperty("user_recv_perception")
    @SerializedName("user_recv_perception")
    private String userRecvPerception;

    @JsonProperty("transfer_scene_report_infos")
    @SerializedName("transfer_scene_report_infos")
    private List<TransferSceneReportInfo> transferSceneReportInfos;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TransferSceneReportInfo {
        @JsonProperty("info_type")
        @SerializedName("info_type")
        private String infoType;

        @JsonProperty("info_content")
        @SerializedName("info_content")
        private String infoContent;
    }
}
    
