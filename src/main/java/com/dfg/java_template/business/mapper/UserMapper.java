package com.dfg.java_template.business.mapper;

import com.dfg.java_template.business.entity.User;
import com.dfg.java_template.framework.generate.abstracts.AbstractMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author zgc
 * @since 2025-07-01 15:18:53
 */
@Mapper
public interface UserMapper extends AbstractMapper<User> {

}
