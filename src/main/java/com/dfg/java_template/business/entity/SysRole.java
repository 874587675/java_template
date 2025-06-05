package com.dfg.java_template.business.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
import java.io.Serial;

/**
* 角色信息表实体类对象
*
* @author zgc
* @since 2025-06-05 17:27:43
*/
@Getter
@Setter
@Builder
@TableName(value = "t_sys_role")
@ApiModel(value = "SysRole对象", description = "角色信息表")
public class SysRole implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "角色ID")
    @TableId(value = "role_id", type = IdType.ASSIGN_ID)
    private String roleId;

    @ApiModelProperty(value = "角色名称")
    @TableField(value = "role_name")
    private String roleName;

    @ApiModelProperty(value = "角色权限")
    @TableField(value = "role_key")
    private String roleKey;

    @ApiModelProperty(value = "顺序")
    @TableField(value = "role_sort")
    private Integer roleSort;

    @ApiModelProperty(value = "数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限 5：仅本人数据权限）")
    @TableField(value = "data_scope")
    private Integer dataScope;

    @ApiModelProperty(value = "角色状态（0正常 1停用）")
    @TableField(value = "role_status")
    private Integer roleStatus;

    @ApiModelProperty(value = "备注")
    @TableField(value = "remark")
    private String remark;

    @ApiModelProperty(value = "创建者ID")
    @TableField(value = "create_user_id", fill = FieldFill.INSERT)
    private String createUserId;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty(value = "更新者ID")
    @TableField(value = "update_user_id", fill = FieldFill.INSERT_UPDATE)
    private String updateUserId;

    @ApiModelProperty(value = "更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @ApiModelProperty(value = "逻辑删除（0-未删除 1-已删除）")
    @TableField(value = "is_deleted", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDeleted;

    @ApiModelProperty(value = "删除时间")
    @TableField(value = "delete_time", fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date deleteTime;

    @ApiModelProperty(value = "版本号")
    @TableField(value = "version", fill = FieldFill.INSERT)
    @Version
    private Integer version;

}