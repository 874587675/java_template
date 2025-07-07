package com.dfg.java_template.framework.pay.wechat.param.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTransferBillByOutNoRequest {

    @JsonProperty("out_bill_no")
    @SerializedName("out_bill_no")
    private String outBillNo;
}
