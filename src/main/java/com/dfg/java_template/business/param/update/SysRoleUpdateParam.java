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
* 角色信息修改参数
* @author zgc
* @since 2025-05-22 18:49:30
*/
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ApiModel(value = "角色信息修改参数", description = "角色信息修改参数对象")
public class SysRoleUpdateParam implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="角色ID",required = true)
    @NotBlank
    private String roleId;

    @ApiModelProperty(value="角色名称")
    private String roleName;

    @ApiModelProperty(value="角色权限")
    private String roleKey;

    @ApiModelProperty(value="顺序")
    private Integer roleSort;

    @ApiModelProperty(value="数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限 5：仅本人数据权限）")
    private Integer dataScope;

    @ApiModelProperty(value="角色状态（0正常 1停用）")
    private Integer roleStatus;

    @ApiModelProperty(value="备注")
    private String remark;

}
