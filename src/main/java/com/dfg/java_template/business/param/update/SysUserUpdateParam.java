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
* 后台用户修改参数
* @author zgc
* @since 2025-07-01 15:33:56
*/
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ApiModel(value = "后台用户修改参数", description = "后台用户修改参数对象")
public class SysUserUpdateParam implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="后台用户ID",required = true)
    @NotBlank
    private String userId;

    @ApiModelProperty(value="后台用户名称")
    private String userName;

    @ApiModelProperty(value="后台用户密码")
    private String password;

    @ApiModelProperty(value="后台用户头像")
    private String avatar;

    @ApiModelProperty(value="后台用户性别（1-男 2-女 3-未知）")
    private Integer sex;

    @ApiModelProperty(value="后台用户邮箱")
    private String email;

    @ApiModelProperty(value="后台用户手机号")
    private String phone;

    @ApiModelProperty(value="用户状态（1-正常 2-冻结）")
    private Integer status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value="最后登录时间")
    private Date lastLoginTime;

    @ApiModelProperty(value="最后登录IP地址")
    private String lastIpAddress;

}
