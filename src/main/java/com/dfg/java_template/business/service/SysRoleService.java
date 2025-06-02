package com.dfg.java_template.business.service;

import com.dfg.java_template.business.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dfg.java_template.business.param.page.vo.PageVO;
import com.dfg.java_template.business.param.save.SysRoleSaveParam;
import com.dfg.java_template.business.param.update.SysRoleUpdateParam;
import com.dfg.java_template.business.param.list.SysRoleListParam;
import com.dfg.java_template.business.param.query.SysRoleQueryParam;
import com.dfg.java_template.business.param.remove.RemoveBaseParam;
import com.dfg.java_template.business.param.vo.SysRoleVO;
/**
* @author zgc
* @since 2025-05-17 19:35:17
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
    * 查询角色信息列表
    *
    * @param sysRoleListParam 查询角色信息列表参数
    * @return 角色信息VO列表
    */
    PageVO<SysRoleVO> listSysRole(SysRoleListParam sysRoleListParam);

    /**
    * 查询角色信息详情
    *
    * @param sysRoleQueryParam 查询角色信息详情参数
    * @return 角色信息VO
    */
    SysRoleVO querySysRole(SysRoleQueryParam sysRoleQueryParam);

    /**
    * 删除角色信息
    *
    * @param removeBaseParam 删除角色信息参数
    */
    void removeSysRole(RemoveBaseParam removeBaseParam);

    }
