package ${package.Entity};

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import java.io.Serializable;
import java.util.Date;
import java.io.Serial;

<#assign moduleName = table.comment?substring(0, table.comment?length - 1)>
/**
* ${table.comment!}实体类对象
*
* @author ${author}
* @since ${date}
*/
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@TableName(value = "<#if schemaName??>${schemaName}</#if>${table.name}")
@ApiModel(value = "${entity}对象", description = "${table.comment!}")
public class ${entity} implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
<#list table.fields as field>
    @ApiModelProperty(value = "${field.comment!}")
<#-- 主键处理 -->
    <#if field.keyFlag>
    @TableId(value = "${field.annotationColumnName}", type = IdType.ASSIGN_ID)
    <#-- 特殊字段处理 -->
    <#elseif field.annotationColumnName == "create_time">
    @TableField(value = "${field.annotationColumnName}", fill = FieldFill.INSERT)
    <#elseif field.annotationColumnName == "create_user_id">
    @TableField(value = "${field.annotationColumnName}", fill = FieldFill.INSERT)
    <#elseif field.annotationColumnName == "update_time">
    @TableField(value = "${field.annotationColumnName}", fill = FieldFill.INSERT_UPDATE)
    <#elseif field.annotationColumnName == "update_user_id">
    @TableField(value = "${field.annotationColumnName}", fill = FieldFill.INSERT_UPDATE)
    <#elseif field.annotationColumnName == "delete_time">
    @TableField(value = "${field.annotationColumnName}", fill = FieldFill.INSERT_UPDATE)
    <#-- 逻辑删除字段处理，避免重复生成 -->
    <#elseif field.logicDeleteField>
    @TableField(value = "${field.annotationColumnName}", fill = FieldFill.INSERT)
    @TableLogic
    <#-- 乐观锁字段处理，避免重复生成 -->
    <#elseif field.versionField>
    @TableField(value = "${field.annotationColumnName}", fill = FieldFill.INSERT)
    @Version
    <#-- 默认字段处理 -->
    <#else>
    @TableField(value = "${field.annotationColumnName}"<#if field.fill??>, fill = FieldFill.${field.fill}</#if>)
    </#if>
<#-- 时间字段格式化 -->
    <#if field.propertyType == "Date">
    <#if field.metaInfo.jdbcType == "DATE">
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    <#else>
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    </#if>
    </#if>
    private ${field.propertyType} ${field.propertyName};

</#list>
}