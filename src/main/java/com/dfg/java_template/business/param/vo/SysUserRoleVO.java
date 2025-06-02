package com.dfg.java_template.business.param.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
* 用户角色关联VO对象
* @author zgc
* @since 2025-05-17 19:35:17
*/
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ApiModel(value = "用户角色关联VO对象", description = "用户角色关联VO对象")
public class SysUserRoleVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="用户角色关联ID")
    private String userRoleId;

    @ApiModelProperty(value="用户ID")
    private String userId;

    @ApiModelProperty(value="角色ID")
    private String roleId;

    @ApiModelProperty(value="创建者ID")
    private String createUserId;

    @ApiModelProperty(value="更新者ID")
    private String updateUserId;

}
