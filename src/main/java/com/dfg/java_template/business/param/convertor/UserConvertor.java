package com.dfg.java_template.business.param.convertor;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.dfg.java_template.business.entity.User;
import com.dfg.java_template.framework.generate.abstracts.AbstractConvertor;
import com.dfg.java_template.business.param.save.UserSaveParam;
import com.dfg.java_template.business.param.update.UserUpdateParam;
import com.dfg.java_template.business.param.vo.UserVO;

import java.util.List;

/**
* UserConvertor
*
* @author zgc
* @since 2025-06-30 11:42:56
*/
@Mapper
public interface UserConvertor extends AbstractConvertor<UserSaveParam , UserUpdateParam, UserVO, User,List<User>,List<UserVO>> {

    UserConvertor SAVE = Mappers.getMapper(UserConvertor.class);

    UserConvertor UPDATE = Mappers.getMapper(UserConvertor.class);

    UserConvertor LIST = Mappers.getMapper(UserConvertor.class);

    UserConvertor QUERY = Mappers.getMapper(UserConvertor.class);

    }