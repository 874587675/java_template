package com.dfg.java_template.business.param.query;

import io.swagger.annotations.ApiModel;
import lombok.*;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.io.Serial;
/**
* 角色信息查询参数
* @author zgc
* @since 2025-05-22 18:49:30
*/
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ApiModel(value = "角色信息查询参数", description = "角色信息查询参数对象")
public class SysRoleQueryParam  implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="角色ID",required = true)
    @NotBlank
    private String roleId;
}
