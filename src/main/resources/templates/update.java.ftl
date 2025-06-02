package ${updatePackage};

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serial;
<#assign moduleName = table.comment?substring(0, table.comment?length - 1)>
/**
* ${moduleName}修改参数
* @author ${author}
* @since ${date}
*/
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ApiModel(value = "${moduleName}修改参数", description = "${moduleName}修改参数对象")
public class ${entity}UpdateParam implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

<#list table.fields as field>
    <#if field.keyFlag>
    @ApiModelProperty(value="${field.comment}",required = true)
    @NotBlank
    private ${field.propertyType} ${field.propertyName};

    </#if>
    <#if !field.keyFlag>
    <#if field.propertyName!="isDeleted" && field.propertyName!="createTime" && field.propertyName!="updateTime" && field.propertyName!="deleteTime" 
    && field.propertyName!="version" && field.propertyName != "createUserId" && field.propertyName != "updateUserId">
    <#if field.propertyType == "Date">
    <#if field.metaInfo.jdbcType == "DATE">
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    <#else>
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    </#if>
    </#if>
    @ApiModelProperty(value="${field.comment}")
    private ${field.propertyType} ${field.propertyName};

    </#if>
    </#if>
</#list>
}
