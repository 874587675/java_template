package com.dfg.java_template.business.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息表实体类对象
 *
 * @author zgc
 * @since 2025-07-01 15:18:53
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@TableName(value = "t_user")
@ApiModel(value = "User对象", description = "用户信息表")
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty(value = "用户ID")
    @TableId(value = "user_id", type = IdType.ASSIGN_ID)
    private String userId;

    @ApiModelProperty(value = "用户名称")
    @TableField(value = "user_name")
    private String userName;

    @ApiModelProperty(value = "登录密码")
    @TableField(value = "password")
    private String password;

    @ApiModelProperty(value = "用户性别（1-男 2-女 3-未知）")
    @TableField(value = "sex")
    private Integer sex;

    @ApiModelProperty(value = "用户昵称")
    @TableField(value = "nick_name")
    private String nickName;

    @ApiModelProperty(value = "用户头像")
    @TableField(value = "avatar")
    private String avatar;

    @ApiModelProperty(value = "用户生日")
    @TableField(value = "birthday")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;

    @ApiModelProperty(value = "手机号码")
    @TableField(value = "phone")
    private String phone;

    @ApiModelProperty(value = "用户状态（1-正常 2-冻结）")
    @TableField(value = "status")
    private Integer status;

    @ApiModelProperty(value = "最后登录时间")
    @TableField(value = "last_login_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastLoginTime;

    @ApiModelProperty(value = "最后登录IP地址")
    @TableField(value = "last_ip_address")
    private String lastIpAddress;

    @ApiModelProperty(value = "逻辑删除（0-未删除 1-已删除）")
    @TableField(value = "is_deleted", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDeleted;

    @ApiModelProperty(value = "删除时间")
    @TableField(value = "delete_time", fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date deleteTime;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @ApiModelProperty(value = "版本号")
    @TableField(value = "version", fill = FieldFill.INSERT)
    @Version
    private Integer version;

}