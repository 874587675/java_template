package com.dfg.java_template.business.param.page;

import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import com.dfg.java_template.business.param.page.bo.PageBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import java.io.Serializable;
import com.dfg.java_template.business.entity.SysUserRole;
import lombok.experimental.SuperBuilder;
import java.io.Serial;


/**
* 用户角色关联列表参数对象
* @author zgc
* @since 2025-06-05 17:27:43
*/
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@ApiModel(value = "用户角色关联查询列表参数", description = "用户角色关联查询列表参数对象")
public class SysUserRolePageParam extends PageBO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="用户角色关联ID")
    private String userRoleId;

}
