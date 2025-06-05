package com.dfg.java_template.business.param.convertor;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.dfg.java_template.business.entity.SysUser;
import com.dfg.java_template.framework.generate.abstracts.AbstractConvertor;
import com.dfg.java_template.business.param.save.SysUserSaveParam;
import com.dfg.java_template.business.param.update.SysUserUpdateParam;
import com.dfg.java_template.business.param.vo.SysUserVO;

import java.util.List;

/**
* SysUserConvertor
*
* @author zgc
* @since 2025-06-05 17:27:43
*/
@Mapper
public interface SysUserConvertor extends AbstractConvertor<SysUserSaveParam , SysUserUpdateParam, SysUserVO, SysUser,List<SysUser>,List<SysUserVO>> {

    SysUserConvertor SAVE = Mappers.getMapper(SysUserConvertor.class);

    SysUserConvertor UPDATE = Mappers.getMapper(SysUserConvertor.class);

    SysUserConvertor LIST = Mappers.getMapper(SysUserConvertor.class);

    SysUserConvertor QUERY = Mappers.getMapper(SysUserConvertor.class);

    }