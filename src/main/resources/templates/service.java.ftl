package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import com.dfg.java_template.business.param.page.vo.PageVO;
import com.dfg.java_template.business.param.save.${entity}SaveParam;
import com.dfg.java_template.business.param.update.${entity}UpdateParam;
import com.dfg.java_template.business.param.list.${entity}ListParam;
import com.dfg.java_template.business.param.query.${entity}QueryParam;
import com.dfg.java_template.business.param.remove.RemoveBaseParam;
import com.dfg.java_template.business.param.vo.${entity}VO;
import java.util.List;
<#assign moduleName = table.comment?substring(0, table.comment?length - 1)>
/**
* @author ${author}
* @since ${date}
*/
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

    /**
    * 保存${moduleName}
    *
    * @param ${entity?uncap_first}SaveParam 保存${moduleName}参数
    */
    void save${entity}(${entity}SaveParam ${entity?uncap_first}SaveParam);

    /**
    * 修改${moduleName}
    *
    * @param ${entity?uncap_first}UpdateParam 修改${moduleName}参数
    */
    void update${entity}(${entity}UpdateParam ${entity?uncap_first}UpdateParam);

    /**
    * 查询${moduleName}列表
    *
    * @param ${entity?uncap_first}ListParam 查询${moduleName}列表参数
    * @return ${moduleName}VO列表
    */
    List<${entity}VO> list${entity}(${entity}ListParam ${entity?uncap_first}ListParam);
    
    /**
    * 分页查询${moduleName}列表
    *
    * @param ${entity?uncap_first}PageParam 查询${moduleName}列表参数
    * @return ${moduleName}VO列表
    */
    PageVO<${entity}VO> page${entity}(${entity}PageParam ${entity?uncap_first}PageParam);

    /**
    * 查询${moduleName}详情
    *
    * @param ${entity?uncap_first}QueryParam 查询${moduleName}详情参数
    * @return ${moduleName}VO
    */
    ${entity}VO query${entity}(${entity}QueryParam ${entity?uncap_first}QueryParam);

    /**
    * 删除${moduleName}
    *
    * @param removeBaseParam 删除${moduleName}参数
    */
    void remove${entity}(RemoveBaseParam removeBaseParam);

    }
