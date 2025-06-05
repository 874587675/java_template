package com.dfg.java_template.business.param.list;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;


/**
* 用户角色关联列表参数对象
* @author zgc
* @since 2025-05-17 19:35:17
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "用户角色关联查询列表参数", description = "用户角色关联查询列表参数对象")
public class SysUserRoleListParam implements Serializable {

    @Serial 
    private static final long serialVersionUID = 1L;

        @ApiModelProperty(value="用户角色关联ID")
        private String userRoleId;

}
