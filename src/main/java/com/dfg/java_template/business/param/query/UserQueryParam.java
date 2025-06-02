package com.dfg.java_template.business.param.query;

import io.swagger.annotations.ApiModel;
import lombok.*;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;import java.io.Serial;
/**
* 用户信息查询参数
* @author zgc
* @since 2025-05-17 19:35:17
*/
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ApiModel(value = "用户信息查询参数", description = "用户信息查询参数对象")
public class UserQueryParam  implements Serializable {

    @Serial
private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="用户ID",required = true)
    @NotBlank
    private String userId;
}
