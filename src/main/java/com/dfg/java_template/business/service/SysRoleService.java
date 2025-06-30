package com.dfg.java_template.business.service;

import com.dfg.java_template.business.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dfg.java_template.business.param.page.vo.PageVO;
import com.dfg.java_template.business.param.save.SysRoleSaveParam;
import com.dfg.java_template.business.param.update.SysRoleUpdateParam;
import com.dfg.java_template.business.param.list.SysRoleListParam;
import com.dfg.java_template.business.param.query.SysRoleQueryParam;
import com.dfg.java_template.business.param.remove.RemoveBaseParam;
import com.dfg.java_template.business.param.page.SysRolePageParam;
import com.dfg.java_template.business.param.vo.SysRoleVO;
import java.util.List;
/**
* @author zgc
* @since 2025-06-30 11:42:56
*/
public interface SysRoleService extends IService<SysRole> {

    /**
    * 保存角色信息
    *
    * @param sysRoleSaveParam 保存角色信息参数
    */
    void saveSysRole(SysRoleSaveParam sysRoleSaveParam);

    /**
    * 修改角色信息
    *
    * @param sysRoleUpdateParam 修改角色信息参数
    */
    void updateSysRole(SysRoleUpdateParam sysRoleUpdateParam);

    /**
    * 删除角色信息
    *
    * @param removeBaseParam 删除角色信息参数
    */
    void removeSysRole(RemoveBaseParam removeBaseParam);

    /**
    * 前台用户查询角色信息列表
    *
    * @param sysRoleListParam 查询角色信息列表参数
    * @return 角色信息VO列表
    */
    List<SysRoleVO> frontListSysRole(SysRoleListParam sysRoleListParam);
    
    /**
    * 前台用户分页查询角色信息列表
    *
    * @param sysRolePageParam 查询角色信息列表参数
    * @return 角色信息VO列表
    */
    PageVO<SysRoleVO> frontPageSysRole(SysRolePageParam sysRolePageParam);

    /**
    * 前台用户查询角色信息详情
    *
    * @param sysRoleQueryParam 查询角色信息详情参数
    * @return 角色信息VO
    */
    SysRoleVO frontQuerySysRole(SysRoleQueryParam sysRoleQueryParam);
        
    /**
    * 后台用户查询角色信息列表
    *
    * @param sysRoleListParam 查询角色信息列表参数
    * @return 角色信息VO列表
    */
    List<SysRoleVO> backListSysRole(SysRoleListParam sysRoleListParam);

    /**
    * 后台用户分页查询角色信息列表
    *
    * @param sysRolePageParam 查询角色信息列表参数
    * @return 角色信息VO列表
    */
    PageVO<SysRoleVO> backPageSysRole(SysRolePageParam sysRolePageParam);

    /**
    * 后台用户查询角色信息详情
    *
    * @param sysRoleQueryParam 查询角色信息详情参数
    * @return 角色信息VO
    */
    SysRoleVO backQuerySysRole(SysRoleQueryParam sysRoleQueryParam);        
}
