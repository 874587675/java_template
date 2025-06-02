package com.dfg.java_template.business.param.remove;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * 删除基础参数
 * @author zgc
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ApiModel(value = "基础删除参数", description = "基础删除参数对象")
public class RemoveBaseParam {

    @ApiModelProperty(value = "主键ID", required = true)
    @NotBlank
    private String serializableId;

}
