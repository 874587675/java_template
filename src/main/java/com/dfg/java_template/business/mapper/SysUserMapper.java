package com.dfg.java_template.business.mapper;

import com.dfg.java_template.business.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 后台用户表 Mapper 接口
 * </p>
 *
 * @author zgc
 * @since 2025-06-05 17:27:43
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

}
