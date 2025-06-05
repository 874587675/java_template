package com.dfg.java_template.business.param.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serial;

/**
* 用户角色关联VO对象
* @author zgc
* @since 2025-06-05 17:27:43
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

}
