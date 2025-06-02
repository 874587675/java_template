package ${package.Convertor};

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ${package.Entity}.${entity};
import com.dfg.java_template.framework.generate.abstracts.AbstractConvertor;
import com.dfg.java_template.business.param.save.${entity}SaveParam;
import com.dfg.java_template.business.param.update.${entity}UpdateParam;
import com.dfg.java_template.business.param.vo.${entity}VO;

import java.util.List;

/**
* ${entity}Convertor
*
* @author zgc
* @since ${date}
*/
@Mapper
public interface ${entity}Convertor extends AbstractConvertor<${entity}SaveParam , ${entity}UpdateParam, ${entity}VO, ${entity},List<${entity}>,List<${entity}VO>> {

    ${entity}Convertor SAVE = Mappers.getMapper(${entity}Convertor.class);

    ${entity}Convertor UPDATE = Mappers.getMapper(${entity}Convertor.class);

    ${entity}Convertor LIST = Mappers.getMapper(${entity}Convertor.class);

    ${entity}Convertor QUERY = Mappers.getMapper(${entity}Convertor.class);

    }