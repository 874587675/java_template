package com.dfg.java_template.business.param.convertor;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.dfg.java_template.business.entity.SysRole;
import com.dfg.java_template.framework.generate.abstracts.AbstractConvertor;
import com.dfg.java_template.business.param.save.SysRoleSaveParam;
import com.dfg.java_template.business.param.update.SysRoleUpdateParam;
import com.dfg.java_template.business.param.vo.SysRoleVO;

import java.util.List;

/**
* SysRoleConvertor
*
* @author zgc
* @since 2025-05-22 18:49:30
*/
@Mapper
public interface SysRoleConvertor extends AbstractConvertor<SysRoleSaveParam , SysRoleUpdateParam, SysRoleVO, SysRole,List<SysRole>,List<SysRoleVO>> {

    SysRoleConvertor SAVE = Mappers.getMapper(SysRoleConvertor.class);

    SysRoleConvertor UPDATE = Mappers.getMapper(SysRoleConvertor.class);

    SysRoleConvertor LIST = Mappers.getMapper(SysRoleConvertor.class);

    SysRoleConvertor QUERY = Mappers.getMapper(SysRoleConvertor.class);

    }