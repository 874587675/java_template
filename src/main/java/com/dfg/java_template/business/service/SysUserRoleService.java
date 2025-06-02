package com.dfg.java_template.business.service;

import com.dfg.java_template.business.entity.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dfg.java_template.business.param.page.vo.PageVO;
import com.dfg.java_template.business.param.save.SysUserRoleSaveParam;
import com.dfg.java_template.business.param.update.SysUserRoleUpdateParam;
import com.dfg.java_template.business.param.list.SysUserRoleListParam;
import com.dfg.java_template.business.param.query.SysUserRoleQueryParam;
import com.dfg.java_template.business.param.remove.RemoveBaseParam;
import com.dfg.java_template.business.param.vo.SysUserRoleVO;
/**
* @author zgc
* @since 2025-05-17 19:35:17
*/
public interface SysUserRoleService extends IService<SysUserRole> {

    /**
    * 保存用户角色关联
    *
    * @param sysUserRoleSaveParam 保存用户角色关联参数
    */
    void saveSysUserRole(SysUserRoleSaveParam sysUserRoleSaveParam);

    /**
    * 修改用户角色关联
    *
    * @param sysUserRoleUpdateParam 修改用户角色关联参数
    */
    void updateSysUserRole(SysUserRoleUpdateParam sysUserRoleUpdateParam);

    /**
    * 查询用户角色关联列表
    *
    * @param sysUserRoleListParam 查询用户角色关联列表参数
    * @return 用户角色关联VO列表
    */
    PageVO<SysUserRoleVO> listSysUserRole(SysUserRoleListParam sysUserRoleListParam);

    /**
    * 查询用户角色关联详情
    *
    * @param sysUserRoleQueryParam 查询用户角色关联详情参数
    * @return 用户角色关联VO
    */
    SysUserRoleVO querySysUserRole(SysUserRoleQueryParam sysUserRoleQueryParam);

    /**
    * 删除用户角色关联
    *
    * @param removeBaseParam 删除用户角色关联参数
    */
    void removeSysUserRole(RemoveBaseParam removeBaseParam);

    }
