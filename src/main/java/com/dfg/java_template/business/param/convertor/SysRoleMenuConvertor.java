package com.dfg.java_template.business.param.convertor;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.dfg.java_template.business.entity.SysRoleMenu;
import com.dfg.java_template.framework.generate.abstracts.AbstractConvertor;
import com.dfg.java_template.business.param.save.SysRoleMenuSaveParam;
import com.dfg.java_template.business.param.update.SysRoleMenuUpdateParam;
import com.dfg.java_template.business.param.vo.SysRoleMenuVO;

import java.util.List;

/**
* SysRoleMenuConvertor
*
* @author zgc
* @since 2025-06-30 11:42:56
*/
@Mapper
public interface SysRoleMenuConvertor extends AbstractConvertor<SysRoleMenuSaveParam , SysRoleMenuUpdateParam, SysRoleMenuVO, SysRoleMenu,List<SysRoleMenu>,List<SysRoleMenuVO>> {

    SysRoleMenuConvertor SAVE = Mappers.getMapper(SysRoleMenuConvertor.class);

    SysRoleMenuConvertor UPDATE = Mappers.getMapper(SysRoleMenuConvertor.class);

    SysRoleMenuConvertor LIST = Mappers.getMapper(SysRoleMenuConvertor.class);

    SysRoleMenuConvertor QUERY = Mappers.getMapper(SysRoleMenuConvertor.class);

    }