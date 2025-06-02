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
* 角色信息新增参数对象
* @author zgc
* @since 2025-05-22 18:49:30
*/
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ApiModel(value = "角色信息新增参数", description = "角色信息新增参数对象")
public class SysRoleSaveParam implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "角色权限")
    private String roleKey;

    @ApiModelProperty(value = "顺序")
    private Integer roleSort;

    @ApiModelProperty(value = "数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限 5：仅本人数据权限）")
    private Integer dataScope;

    @ApiModelProperty(value = "角色状态（0正常 1停用）")
    private Integer roleStatus;

    @ApiModelProperty(value = "备注")
    private String remark;

}
