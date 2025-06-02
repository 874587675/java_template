package com.dfg.java_template.business.param.convertor;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.dfg.java_template.business.entity.SysMenu;
import com.dfg.java_template.framework.generate.abstracts.AbstractConvertor;
import com.dfg.java_template.business.param.save.SysMenuSaveParam;
import com.dfg.java_template.business.param.update.SysMenuUpdateParam;
import com.dfg.java_template.business.param.vo.SysMenuVO;

import java.util.List;

/**
* SysMenuConvertor
*
* @author zgc
* @since 2025-05-26 09:31:55
*/
@Mapper
public interface SysMenuConvertor extends AbstractConvertor<SysMenuSaveParam , SysMenuUpdateParam, SysMenuVO, SysMenu,List<SysMenu>,List<SysMenuVO>> {

    SysMenuConvertor SAVE = Mappers.getMapper(SysMenuConvertor.class);

    SysMenuConvertor UPDATE = Mappers.getMapper(SysMenuConvertor.class);

    SysMenuConvertor LIST = Mappers.getMapper(SysMenuConvertor.class);

    SysMenuConvertor QUERY = Mappers.getMapper(SysMenuConvertor.class);

    }