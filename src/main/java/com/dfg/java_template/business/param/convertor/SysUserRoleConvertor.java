package com.dfg.java_template.business.param.convertor;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.dfg.java_template.business.entity.SysUserRole;
import com.dfg.java_template.framework.generate.abstracts.AbstractConvertor;
import com.dfg.java_template.business.param.save.SysUserRoleSaveParam;
import com.dfg.java_template.business.param.update.SysUserRoleUpdateParam;
import com.dfg.java_template.business.param.vo.SysUserRoleVO;

import java.util.List;

/**
* SysUserRoleConvertor
*
* @author zgc
* @since 2025-06-05 17:27:43
*/
@Mapper
public interface SysUserRoleConvertor extends AbstractConvertor<SysUserRoleSaveParam , SysUserRoleUpdateParam, SysUserRoleVO, SysUserRole,List<SysUserRole>,List<SysUserRoleVO>> {

    SysUserRoleConvertor SAVE = Mappers.getMapper(SysUserRoleConvertor.class);

    SysUserRoleConvertor UPDATE = Mappers.getMapper(SysUserRoleConvertor.class);

    SysUserRoleConvertor LIST = Mappers.getMapper(SysUserRoleConvertor.class);

    SysUserRoleConvertor QUERY = Mappers.getMapper(SysUserRoleConvertor.class);

    }