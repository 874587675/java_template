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
* 后台用户表实体类对象
*
* @author zgc
* @since 2025-05-23 16:40:10
*/
@Getter
@Setter
@Builder
@TableName(value = "t_sys_user")
@ApiModel(value = "SysUser对象", description = "后台用户表")
public class SysUser implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "后台用户ID")
    @TableId(value = "user_id", type = IdType.ASSIGN_ID)
    private String userId;

    @ApiModelProperty(value = "后台用户名称")
    @TableField(value = "user_name")
    private String userName;

    @ApiModelProperty(value = "后台用户密码")
    @TableField(value = "password")
    private String password;

    @ApiModelProperty(value = "后台用户头像")
    @TableField(value = "avatar")
    private String avatar;

    @ApiModelProperty(value = "后台用户性别（1-男 2-女 3-未知）")
    @TableField(value = "sex")
    private Integer sex;

    @ApiModelProperty(value = "后台用户邮箱")
    @TableField(value = "email")
    private String email;

    @ApiModelProperty(value = "后台用户手机号")
    @TableField(value = "phone")
    private String phone;

    @ApiModelProperty(value = "用户状态（1-正常 2-冻结）")
    @TableField(value = "status")
    private Integer status;

    @ApiModelProperty(value = "最后登录时间")
    @TableField(value = "last_login_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastLoginTime;

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