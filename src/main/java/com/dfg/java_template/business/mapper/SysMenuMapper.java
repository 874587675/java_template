package com.dfg.java_template.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dfg.java_template.business.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 *
 * @author zgc
 * @since 2025-06-05 17:27:43
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    List<String> selectMenuByUserId(@Param("userId") String userId);
}
