package com.dfg.java_template.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dfg.java_template.business.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色信息表 Mapper 接口
 * </p>
 *
 * @author zgc
 * @since 2025-05-22 18:49:30
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
    List<String> selectRoleByUserId(@Param("userId") String userId);
}
