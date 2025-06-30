package com.dfg.java_template.business.mapper;

import com.dfg.java_template.business.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author zgc
 * @since 2025-06-30 11:42:56
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
