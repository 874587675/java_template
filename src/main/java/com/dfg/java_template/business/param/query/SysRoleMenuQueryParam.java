package com.dfg.java_template.business.param.query;

import io.swagger.annotations.ApiModel;
import lombok.*;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.io.Serial;
/**
* 角色和菜单关联查询参数
* @author zgc
* @since 2025-06-30 11:42:56
*/
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ApiModel(value = "角色和菜单关联查询参数", description = "角色和菜单关联查询参数对象")
public class SysRoleMenuQueryParam  implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="角色菜单主键",required = true)
    @NotBlank
    private String roleMenuId;
}
