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
* 菜单权限表实体类对象
*
* @author zgc
* @since 2025-05-26 09:31:55
*/
@Getter
@Setter
@Builder
@TableName(value = "t_sys_menu")
@ApiModel(value = "SysMenu对象", description = "菜单权限表")
public class SysMenu implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "菜单ID")
    @TableId(value = "menu_id", type = IdType.ASSIGN_ID)
    private String menuId;

    @ApiModelProperty(value = "菜单名称")
    @TableField(value = "menu_name")
    private String menuName;

    @ApiModelProperty(value = "父菜单ID")
    @TableField(value = "parent_id")
    private String parentId;

    @ApiModelProperty(value = "显示顺序")
    @TableField(value = "menu_sort")
    private Integer menuSort;

    @ApiModelProperty(value = "菜单类型（1-目录 2-菜单 3-按钮）")
    @TableField(value = "menu_type")
    private Integer menuType;

    @ApiModelProperty(value = "菜单显示（0隐藏 1显示）")
    @TableField(value = "visible")
    private Integer visible;

    @ApiModelProperty(value = "菜单状态（0停用 1正常）")
    @TableField(value = "status")
    private Integer status;

    @ApiModelProperty(value = "权限标识")
    @TableField(value = "permission")
    private String permission;

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