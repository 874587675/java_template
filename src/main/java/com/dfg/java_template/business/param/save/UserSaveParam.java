package com.dfg.java_template.business.param.save;

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
* 用户信息新增参数对象
* @author zgc
* @since 2025-05-17 19:35:17
*/
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ApiModel(value = "用户信息新增参数", description = "用户信息新增参数对象")
public class UserSaveParam implements Serializable {

    @Serial
private static final long serialVersionUID = 1L;

        @ApiModelProperty(value = "用户名称")
        private String userName;

        @ApiModelProperty(value = "登录密码")
        private String password;

        @ApiModelProperty(value = "用户性别（1-男 2-女 3-未知）")
        private String sex;

        @ApiModelProperty(value = "用户昵称")
        private String nickName;

        @ApiModelProperty(value = "用户头像")
        private String avatar;

        @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
        @ApiModelProperty(value = "用户生日")
        private Date birthday;

        @ApiModelProperty(value = "手机号码")
        private String phone;

        @ApiModelProperty(value = "用户状态（1-正常 2-冻结）")
        private Integer status;

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        @ApiModelProperty(value = "最后登录时间")
        private Date lastLoginTime;

}
