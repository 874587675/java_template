package com.dfg.java_template.framework.pay.wechat.param.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTransferBillResponse {
    @JsonProperty("mch_id")
    @SerializedName("mch_id")
    private String mchId;
    
    @JsonProperty("out_bill_no")
    @SerializedName("out_bill_no")
    private String outBillNo;

    @JsonProperty("transfer_bill_no")
    @SerializedName("transfer_bill_no")
    private String transferBillNo;

    @JsonProperty("appid")
    @SerializedName("appid")
    private String appId;

    @JsonProperty("state")
    @SerializedName("state")
    private String state;

    @JsonProperty("transfer_amount")
    @SerializedName("transfer_amount")
    private Integer transferAmount;

    @JsonProperty("package_info")
    @SerializedName("package_info")
    private String packageInfo;

    @JsonProperty("transfer_remark")
    @SerializedName("transfer_remark")
    private String transferRemark;

    @JsonProperty("fail_reason")
    @SerializedName("fail_reason")
    private String failReason;

    @JsonProperty("openid")
    @SerializedName("openid")
    private String openId;

    @JsonProperty("user_name")
    @SerializedName("user_name")
    private String user_name;

    @JsonProperty("create_time")
    @SerializedName("create_time")
    private String createTime;

    @JsonProperty("update_time")
    @SerializedName("update_time")
    private String updateTime;

}
