package com.dfg.java_template.business.param.list;

import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import java.io.Serializable;
import com.dfg.java_template.business.entity.SysUser;
import java.io.Serial;


/**
* 后台用户列表参数对象
* @author zgc
* @since 2025-06-30 11:42:56
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
