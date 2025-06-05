package ${pagePackage};

<#list table.importPackages as pkg>
    <#if
    pkg != "java.util.Date"
    && pkg != "com.baomidou.mybatisplus.annotation.FieldFill"
    && pkg != "com.baomidou.mybatisplus.annotation.TableField"
    && pkg != "com.baomidou.mybatisplus.annotation.TableId"
    && pkg != "com.baomidou.mybatisplus.annotation.TableLogic"
    && pkg != "com.baomidou.mybatisplus.annotation.TableName"
    >
import ${pkg};
    </#if>
</#list>
import com.dfg.java_template.business.param.page.bo.PageBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import java.io.Serializable;
import com.dfg.java_template.business.entity.${entity};
import lombok.experimental.SuperBuilder;
import java.io.Serial;

<#assign moduleName = table.comment?substring(0, table.comment?length - 1)>

/**
* ${moduleName}列表参数对象
* @author ${author}
* @since ${date}
*/
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@ApiModel(value = "${moduleName}查询列表参数", description = "${moduleName}查询列表参数对象")
public class ${entity}PageParam extends PageBO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

<#list table.fields as field>
    <#if field.keyFlag>
    @ApiModelProperty(value="${field.comment}")
    private ${field.propertyType} ${field.propertyName};
    </#if>
</#list>

}
