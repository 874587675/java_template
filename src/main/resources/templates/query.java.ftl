package ${queryPackage};

import io.swagger.annotations.ApiModel;
import lombok.*;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.io.Serial;
<#assign moduleName = table.comment?substring(0, table.comment?length - 1)>
/**
* ${moduleName}查询参数
* @author ${author}
* @since ${date}
*/
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ApiModel(value = "${moduleName}查询参数", description = "${moduleName}查询参数对象")
public class ${entity}QueryParam  implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

<#list table.fields as field>
    <#if field.keyFlag>
    @ApiModelProperty(value="${field.comment}",required = true)
    @NotBlank
    private ${field.propertyType} ${field.propertyName};
    </#if>
</#list>
}
