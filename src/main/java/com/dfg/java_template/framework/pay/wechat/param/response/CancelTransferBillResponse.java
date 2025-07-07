package com.dfg.java_template.framework.pay.wechat.param.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CancelTransferBillResponse {
    @JsonProperty("out_bill_no")
    @SerializedName("out_bill_no")
    private String outBillNo;

    @JsonProperty("transfer_bill_no")
    @SerializedName("transfer_bill_no")
    private String transferBillNo;

    @JsonProperty("state")
    @SerializedName("state")
    private String state;

    @JsonProperty("package_info")
    @SerializedName("package_info")
    private String packageInfo;


}

