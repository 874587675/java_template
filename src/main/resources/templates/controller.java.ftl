package ${package.Controller};

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ${package.Service}.${table.serviceName};
import javax.annotation.Resource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import com.dfg.java_template.framework.web.R;
import com.dfg.java_template.business.param.page.vo.PageVO;
import com.dfg.java_template.business.param.remove.RemoveBaseParam;
import com.dfg.java_template.business.param.update.${entity}UpdateParam;
import com.dfg.java_template.business.param.list.${entity}ListParam;
import com.dfg.java_template.business.param.query.${entity}QueryParam;
import com.dfg.java_template.business.param.save.${entity}SaveParam;
import com.dfg.java_template.business.param.page.${entity}PageParam;
import com.dfg.java_template.business.param.vo.${entity}VO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.validation.annotation.Validated;
import java.util.List;

<#assign moduleName = table.comment?substring(0, table.comment?length - 1)>

/**
* ${moduleName} 模块
* @author ${author}
* @since ${date}
*/
@Api(value = "${moduleName}模块", tags = "${moduleName}模块相关接口")
@RestController
@RequestMapping("/api/v1<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle>${table.entityPath?replace('^t_', '', 'r')?uncap_first}<#else>${table.entityPath?replace('^t_', '', 'r')?uncap_first}</#if>")
public class ${table.controllerName} {
    @Resource
    private ${table.serviceName} ${table.serviceName?uncap_first};

    @PostMapping(value = "/save${entity}", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "新增${moduleName}", produces = "application/json", consumes = "application/json")
    public R<?> save${entity}(@Validated @RequestBody ${entity}SaveParam ${entity?uncap_first}SaveParam){
        ${table.serviceName?uncap_first}.save${entity}(${entity?uncap_first}SaveParam);
        return R.ok();
    }

    @PostMapping(value = "/update${entity}", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "根据主键修改${moduleName}", produces = "application/json", consumes = "application/json")
    public R<?> update${entity}(@Validated @RequestBody ${entity}UpdateParam ${entity?uncap_first}UpdateParam){
        ${table.serviceName?uncap_first}.update${entity}(${entity?uncap_first}UpdateParam);
        return R.ok();
    }

    @ApiOperation(value = "根据主键删除${moduleName}", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/remove${entity}", produces = "application/json", consumes = "application/json")
    public R<?> remove${entity}(@Validated @RequestBody RemoveBaseParam removeBaseParam){
        ${table.serviceName?uncap_first}.remove${entity}(removeBaseParam);
        return R.ok();
    }

    @ApiOperation(value = "前台用户查询${moduleName}列表", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/frontList${entity}", produces = "application/json", consumes = "application/json")
    public R<List<${entity}VO>> frontList${entity}(@Validated @RequestBody ${entity}ListParam ${entity?uncap_first}ListParam){
        return R.ok(${table.serviceName?uncap_first}.frontList${entity}(${entity?uncap_first}ListParam));
    }

    @ApiOperation(value = "前台用户分页查询${moduleName}列表", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/frontPage${entity}", produces = "application/json", consumes = "application/json")
    public R<PageVO<${entity}VO>> frontPage${entity}(@Validated @RequestBody ${entity}PageParam ${entity?uncap_first}PageParam){
        return R.ok(${table.serviceName?uncap_first}.frontPage${entity}(${entity?uncap_first}PageParam));
    }

    @ApiOperation(value = "前台用户查询${moduleName}详情", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/frontQuery${entity}", produces = "application/json", consumes = "application/json")
    public R<${entity}VO> frontQuery${entity}(@Validated @RequestBody ${entity}QueryParam ${entity?uncap_first}QueryParam){
        return R.ok(${table.serviceName?uncap_first}.frontQuery${entity}(${entity?uncap_first}QueryParam));
    }

    @ApiOperation(value = "后台用户查询${moduleName}列表", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/backList${entity}", produces = "application/json", consumes = "application/json")
    public R<List<${entity}VO>> backList${entity}(@Validated @RequestBody ${entity}ListParam ${entity?uncap_first}ListParam){
        return R.ok(${table.serviceName?uncap_first}.backList${entity}(${entity?uncap_first}ListParam));
        }

    @ApiOperation(value = "后台用户分页查询${moduleName}列表", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/backPage${entity}", produces = "application/json", consumes = "application/json")
    public R<PageVO<${entity}VO>> backPage${entity}(@Validated @RequestBody ${entity}PageParam ${entity?uncap_first}PageParam){
        return R.ok(${table.serviceName?uncap_first}.backPage${entity}(${entity?uncap_first}PageParam));
        }
    
    @ApiOperation(value = "后台用户查询${moduleName}详情", produces = "application/json", consumes = "application/json")
    @PostMapping(value = "/backQuery${entity}", produces = "application/json", consumes = "application/json")
    public R<${entity}VO> backQuery${entity}(@Validated @RequestBody ${entity}QueryParam ${entity?uncap_first}QueryParam){
        return R.ok(${table.serviceName?uncap_first}.backQuery${entity}(${entity?uncap_first}QueryParam));
        }            

}
