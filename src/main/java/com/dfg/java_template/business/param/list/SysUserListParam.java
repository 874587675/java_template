package com.dfg.java_template.business.param.list;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;


/**
* 后台用户列表参数对象
* @author zgc
* @since 2025-05-23 16:40:10
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "后台用户查询列表参数", description = "后台用户查询列表参数对象")
public class SysUserListParam implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="后台用户ID")
    private String userId;

}
