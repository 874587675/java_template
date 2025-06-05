package com.dfg.java_template.business.param.query;

import io.swagger.annotations.ApiModel;
import lombok.*;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.io.Serial;
/**
* 菜单权限查询参数
* @author zgc
* @since 2025-06-05 17:27:43
*/
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ApiModel(value = "菜单权限查询参数", description = "菜单权限查询参数对象")
public class SysMenuQueryParam  implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="菜单ID",required = true)
    @NotBlank
    private String menuId;
}
