package com.dfg.java_template.business.param.update;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serial;
/**
* 用户角色关联修改参数
* @author zgc
* @since 2025-06-30 11:42:56
*/
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ApiModel(value = "用户角色关联修改参数", description = "用户角色关联修改参数对象")
public class SysUserRoleUpdateParam implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="用户角色关联ID",required = true)
    @NotBlank
    private String userRoleId;

    @ApiModelProperty(value="用户ID")
    private String userId;

    @ApiModelProperty(value="角色ID")
    private String roleId;

}
