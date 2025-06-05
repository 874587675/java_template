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
* 角色信息列表参数对象
* @author zgc
* @since 2025-05-22 18:49:30
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "角色信息查询列表参数", description = "角色信息查询列表参数对象")
public class SysRoleListParam  extends PageBO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="角色ID")
    private String roleId;

}
