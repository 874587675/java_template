package ${savePackage};

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;
import java.io.Serial;
import com.fasterxml.jackson.annotation.JsonFormat;

<#assign moduleName = table.comment?substring(0, table.comment?length - 1)>
/**
* ${moduleName}新增参数对象
* @author ${author}
* @since ${date}
*/
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ApiModel(value = "${moduleName}新增参数", description = "${moduleName}新增参数对象")
public class ${entity}SaveParam implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

<#list table.fields as field>
    <#if !field.keyFlag && field.propertyName != "isDeleted" && field.propertyName != "createTime" && field.propertyName != "updateTime" 
    && field.propertyName != "deleteTime" && field.propertyName != "version"
    && field.propertyName != "createUserId" && field.propertyName != "updateUserId">
    <#if field.propertyType == "Date">
    <#if field.metaInfo.jdbcType == "DATE">
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    <#else>
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    </#if>
    </#if>
    @ApiModelProperty(value = "${field.comment}")
    private ${field.propertyType} ${field.propertyName};

    </#if>
</#list>
}
