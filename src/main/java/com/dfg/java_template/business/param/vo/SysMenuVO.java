package com.dfg.java_template.business.param.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serial;

/**
* 菜单权限VO对象
* @author zgc
* @since 2025-05-26 09:31:55
*/
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ApiModel(value = "菜单权限VO对象", description = "菜单权限VO对象")
public class SysMenuVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="菜单ID")
    private String menuId;

    @ApiModelProperty(value="菜单名称")
    private String menuName;

    @ApiModelProperty(value="父菜单ID")
    private String parentId;

    @ApiModelProperty(value="显示顺序")
    private Integer menuSort;

    @ApiModelProperty(value="菜单类型（1-目录 2-菜单 3-按钮）")
    private Integer menuType;

    @ApiModelProperty(value="菜单显示（0隐藏 1显示）")
    private Integer visible;

    @ApiModelProperty(value="菜单状态（0停用 1正常）")
    private Integer status;

    @ApiModelProperty(value="权限标识")
    private String permission;

    @ApiModelProperty(value="备注")
    private String remark;

}
