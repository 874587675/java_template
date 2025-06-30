package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dfg.java_template.business.param.vo.${entity}VO;
import com.dfg.java_template.business.param.page.vo.PageVO;
import com.dfg.java_template.business.param.save.${entity}SaveParam;
import com.dfg.java_template.business.param.update.${entity}UpdateParam;
import com.dfg.java_template.business.param.list.${entity}ListParam;
import com.dfg.java_template.business.param.query.${entity}QueryParam;
import com.dfg.java_template.business.param.remove.RemoveBaseParam;
import com.dfg.java_template.business.param.page.${entity}PageParam;
import cn.hutool.core.util.ObjectUtil;
import javax.annotation.Resource;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.transaction.annotation.Transactional;
import com.dfg.java_template.business.param.convertor.${entity}Convertor;
import java.util.List;
<#assign moduleName = table.comment?substring(0, table.comment?length - 1)>

/**
* <p>
* ${table.comment!} 服务实现类
* </p>
*
* @author ${author}
* @since ${date}
*/
@Service
@Slf4j
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {
    @Resource
    private ${table.mapperName} ${table.mapperName?uncap_first};

    /**
    * 保存${moduleName}
    *
    * @param ${entity?uncap_first}SaveParam 保存${moduleName}参数
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save${entity}(${entity}SaveParam ${entity?uncap_first}SaveParam){
        ${table.mapperName?uncap_first}.insert(${entity}Convertor.SAVE.saveParamToEntity(${entity?uncap_first}SaveParam));
    }

    /**
    * 修改${moduleName}
    *
    * @param ${entity?uncap_first}UpdateParam 修改${moduleName}参数
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update${entity}(${entity}UpdateParam ${entity?uncap_first}UpdateParam){
        ${table.mapperName?uncap_first}.updateById(${entity}Convertor.UPDATE.updateParamToEntity(${entity?uncap_first}UpdateParam));
    }

    /**
    * 删除${moduleName}属性
    *
    * @param removeBaseParam 删除${moduleName}属性参数
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove${entity}(RemoveBaseParam removeBaseParam) {
        ${table.mapperName?uncap_first}.deleteById(removeBaseParam.getSerializableId());
    }

    /**
    * 前台用户查询${moduleName}列表
    *
    * @param ${entity?uncap_first}ListParam 查询${moduleName}列表参数
    * @return ${moduleName}VO列表
    */
    @Override
    public List<${entity}VO> frontList${entity}(${entity}ListParam ${entity?uncap_first}ListParam){
        String ${entity?substring(0,1)?lower_case + entity?substring(1)}Id = ${entity?uncap_first}ListParam.get${entity}Id();
        List<${entity}> list =list(
                new LambdaQueryWrapper<${entity}>()
                        .eq(ObjectUtil.isNotEmpty(${entity?substring(0,1)?lower_case + entity?substring(1)}Id), ${entity}::get${entity}Id, ${entity?substring(0,1)?lower_case + entity?substring(1)}Id)
                        .orderByDesc(${entity}::getCreateTime)
        );
        return ${entity}Convertor.LIST.listEntityToListVO(list);
    }

    /**
    * 前台用户分页查询${moduleName}列表
    *
    * @param ${entity?uncap_first}PageParam 查询${moduleName}列表参数
    * @return ${moduleName}VO列表
    */
    @Override
    public PageVO<${entity}VO> frontPage${entity}(${entity}PageParam ${entity?uncap_first}PageParam){
        String ${entity?substring(0,1)?lower_case + entity?substring(1)}Id = ${entity?uncap_first}PageParam.get${entity}Id();
        Page<${entity}> page = page(new Page<>(${entity?uncap_first}PageParam.getPageNo(), ${entity?uncap_first}PageParam.getPageSize()),
                new LambdaQueryWrapper<${entity}>()
                        .eq(ObjectUtil.isNotEmpty(${entity?substring(0,1)?lower_case + entity?substring(1)}Id), ${entity}::get${entity}Id, ${entity?substring(0,1)?lower_case + entity?substring(1)}Id)
                        .orderByDesc(${entity}::getCreateTime)
        );
        return PageVO.addPageData(page, ${entity}Convertor.LIST.listEntityToListVO(page.getRecords()));
    }

    /**
    * 前台用户查询${moduleName}详情
    *
    * @param ${entity?uncap_first}QueryParam 查询${moduleName}详情参数
    * @return ${moduleName}VO
    */
    @Override
    public ${entity}VO frontQuery${entity}(${entity}QueryParam ${entity?uncap_first}QueryParam){
        return ${entity}Convertor.QUERY.entityToVo(${table.mapperName?uncap_first}.selectById(${entity?uncap_first}QueryParam.get${entity}Id()));
    }

    /**
    * 后台用户查询${moduleName}列表
    *
    * @param ${entity?uncap_first}ListParam 查询${moduleName}列表参数
    * @return ${moduleName}VO列表
    */
    @Override
    public List<${entity}VO> backList${entity}(${entity}ListParam ${entity?uncap_first}ListParam){
        String ${entity?substring(0,1)?lower_case + entity?substring(1)}Id = ${entity?uncap_first}ListParam.get${entity}Id();
        List<${entity}> list =list(
                new LambdaQueryWrapper<${entity}>()
                    .eq(ObjectUtil.isNotEmpty(${entity?substring(0,1)?lower_case + entity?substring(1)}Id), ${entity}::get${entity}Id, ${entity?substring(0,1)?lower_case + entity?substring(1)}Id)
                    .orderByDesc(${entity}::getCreateTime)
        );
        return ${entity}Convertor.LIST.listEntityToListVO(list);
    }

    /**
    * 后台用户分页查询${moduleName}列表
    *
    * @param ${entity?uncap_first}PageParam 查询${moduleName}列表参数
    * @return ${moduleName}VO列表
    */
    @Override
    public PageVO<${entity}VO> backPage${entity}(${entity}PageParam ${entity?uncap_first}PageParam){
        String ${entity?substring(0,1)?lower_case + entity?substring(1)}Id = ${entity?uncap_first}PageParam.get${entity}Id();
        Page<${entity}> page = page(new Page<>(${entity?uncap_first}PageParam.getPageNo(), ${entity?uncap_first}PageParam.getPageSize()),
                new LambdaQueryWrapper<${entity}>()
                    .eq(ObjectUtil.isNotEmpty(${entity?substring(0,1)?lower_case + entity?substring(1)}Id), ${entity}::get${entity}Id, ${entity?substring(0,1)?lower_case + entity?substring(1)}Id)
                    .orderByDesc(${entity}::getCreateTime)
        );
        return PageVO.addPageData(page, ${entity}Convertor.LIST.listEntityToListVO(page.getRecords()));
    }

    /**
    * 后台用户查询${moduleName}详情
    *
    * @param ${entity?uncap_first}QueryParam 查询${moduleName}详情参数
    * @return ${moduleName}VO
    */
    @Override
    public ${entity}VO backQuery${entity}(${entity}QueryParam ${entity?uncap_first}QueryParam){
        return ${entity}Convertor.QUERY.entityToVo(${table.mapperName?uncap_first}.selectById(${entity?uncap_first}QueryParam.get${entity}Id()));
    }        
        
}
