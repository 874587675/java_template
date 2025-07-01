package com.dfg.java_template.business.param.list;

import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import java.io.Serializable;
import com.dfg.java_template.business.entity.User;
import java.io.Serial;


/**
* 用户信息列表参数对象
* @author zgc
* @since 2025-07-01 15:18:53
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "用户信息查询列表参数", description = "用户信息查询列表参数对象")
public class UserListParam implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="用户ID")
    private String userId;

}
