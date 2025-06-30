package com.dfg.java_template.business.param.list;

import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import java.io.Serializable;
import com.dfg.java_template.business.entity.SysMenu;
import java.io.Serial;


/**
* 菜单权限列表参数对象
* @author zgc
* @since 2025-06-30 11:38:23
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "菜单权限查询列表参数", description = "菜单权限查询列表参数对象")
public class SysMenuListParam implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="菜单ID")
    private String menuId;

}
