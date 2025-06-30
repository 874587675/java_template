package com.dfg.java_template.business.param.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;
import java.io.Serial;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
* 角色和菜单关联新增参数对象
* @author zgc
* @since 2025-06-30 11:42:56
*/
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ApiModel(value = "角色和菜单关联新增参数", description = "角色和菜单关联新增参数对象")
public class SysRoleMenuSaveParam implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色ID")
    private String roleId;

    @ApiModelProperty(value = "菜单ID")
    private String menuId;

}
