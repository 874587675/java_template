package com.dfg.java_template.business.param.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serial;

/**
* 角色和菜单关联VO对象
* @author zgc
* @since 2025-06-30 11:42:56
*/
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ApiModel(value = "角色和菜单关联VO对象", description = "角色和菜单关联VO对象")
public class SysRoleMenuVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="角色菜单主键")
    private String roleMenuId;

    @ApiModelProperty(value="角色ID")
    private String roleId;

    @ApiModelProperty(value="菜单ID")
    private String menuId;

}
