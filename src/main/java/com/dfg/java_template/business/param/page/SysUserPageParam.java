package com.dfg.java_template.business.param.page;

import java.io.Serializable;
import com.dfg.java_template.business.param.page.bo.PageBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.io.Serial;


/**
* 后台用户列表参数对象
* @author zgc
* @since 2025-05-23 16:40:10
*/
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@ApiModel(value = "后台用户查询列表参数", description = "后台用户查询列表参数对象")
public class SysUserPageParam extends PageBO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="后台用户ID")
    private String userId;

}
