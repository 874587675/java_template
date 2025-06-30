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
* 用户信息修改参数
* @author zgc
* @since 2025-06-30 11:42:56
*/
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ApiModel(value = "用户信息修改参数", description = "用户信息修改参数对象")
public class UserUpdateParam implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="用户ID",required = true)
    @NotBlank
    private String userId;

    @ApiModelProperty(value="用户名称")
    private String userName;

    @ApiModelProperty(value="登录密码")
    private String password;

    @ApiModelProperty(value="用户性别（1-男 2-女 3-未知）")
    private Integer sex;

    @ApiModelProperty(value="用户昵称")
    private String nickName;

    @ApiModelProperty(value="用户头像")
    private String avatar;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value="用户生日")
    private Date birthday;

    @ApiModelProperty(value="手机号码")
    private String phone;

    @ApiModelProperty(value="用户状态（1-正常 2-冻结）")
    private Integer status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value="最后登录时间")
    private Date lastLoginTime;

}
