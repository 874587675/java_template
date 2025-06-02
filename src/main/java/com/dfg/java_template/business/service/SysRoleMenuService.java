package com.dfg.java_template.business.service;

import com.dfg.java_template.business.entity.SysRoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dfg.java_template.business.param.page.vo.PageVO;
import com.dfg.java_template.business.param.save.SysRoleMenuSaveParam;
import com.dfg.java_template.business.param.update.SysRoleMenuUpdateParam;
import com.dfg.java_template.business.param.list.SysRoleMenuListParam;
import com.dfg.java_template.business.param.query.SysRoleMenuQueryParam;
import com.dfg.java_template.business.param.remove.RemoveBaseParam;
import com.dfg.java_template.business.param.vo.SysRoleMenuVO;
/**
* @author zgc
* @since 2025-05-22 18:49:30
*/
public interface SysRoleMenuService extends IService<SysRoleMenu> {

    /**
    * 保存角色和菜单关联
    *
    * @param sysRoleMenuSaveParam 保存角色和菜单关联参数
    */
    void saveSysRoleMenu(SysRoleMenuSaveParam sysRoleMenuSaveParam);

    /**
    * 修改角色和菜单关联
    *
    * @param sysRoleMenuUpdateParam 修改角色和菜单关联参数
    */
    void updateSysRoleMenu(SysRoleMenuUpdateParam sysRoleMenuUpdateParam);

    /**
    * 查询角色和菜单关联列表
    *
    * @param sysRoleMenuListParam 查询角色和菜单关联列表参数
    * @return 角色和菜单关联VO列表
    */
    PageVO<SysRoleMenuVO> listSysRoleMenu(SysRoleMenuListParam sysRoleMenuListParam);

    /**
    * 查询角色和菜单关联详情
    *
    * @param sysRoleMenuQueryParam 查询角色和菜单关联详情参数
    * @return 角色和菜单关联VO
    */
    SysRoleMenuVO querySysRoleMenu(SysRoleMenuQueryParam sysRoleMenuQueryParam);

    /**
    * 删除角色和菜单关联
    *
    * @param removeBaseParam 删除角色和菜单关联参数
    */
    void removeSysRoleMenu(RemoveBaseParam removeBaseParam);

    }
