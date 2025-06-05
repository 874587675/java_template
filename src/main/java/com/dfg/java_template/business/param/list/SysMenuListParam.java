package com.dfg.java_template.business.param.list;

import com.dfg.java_template.business.param.page.bo.PageBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;


/**
* 菜单权限列表参数对象
* @author zgc
* @since 2025-05-26 09:31:55
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "菜单权限查询列表参数", description = "菜单权限查询列表参数对象")
public class SysMenuListParam  extends PageBO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="菜单ID")
    private String menuId;

}
