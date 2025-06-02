package com.dfg.java_template.business.param.list;

import com.dfg.java_template.business.param.page.bo.PageBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.io.Serializable;


/**
 * 用户信息列表参数对象
 *
 * @author zgc
 * @since 2025-05-17 19:35:17
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@ApiModel(value = "用户信息查询列表参数", description = "用户信息查询列表参数对象")
public class UserListParam extends PageBO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID")
    private String userId;

}
