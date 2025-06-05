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
* 用户角色关联表实体类对象
*
* @author zgc
* @since 2025-06-05 17:27:43
*/
@Getter
@Setter
@Builder
@TableName(value = "t_sys_user_role")
@ApiModel(value = "SysUserRole对象", description = "用户角色关联表")
public class SysUserRole implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "用户角色关联ID")
    @TableId(value = "user_role_id", type = IdType.ASSIGN_ID)
    private String userRoleId;

    @ApiModelProperty(value = "用户ID")
    @TableField(value = "user_id")
    private String userId;

    @ApiModelProperty(value = "角色ID")
    @TableField(value = "role_id")
    private String roleId;

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