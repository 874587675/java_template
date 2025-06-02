package com.dfg.java_template.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dfg.java_template.business.entity.SysMenu;
import com.dfg.java_template.business.param.list.SysMenuListParam;
import com.dfg.java_template.business.param.page.vo.PageVO;
import com.dfg.java_template.business.param.query.SysMenuQueryParam;
import com.dfg.java_template.business.param.remove.RemoveBaseParam;
import com.dfg.java_template.business.param.save.SysMenuSaveParam;
import com.dfg.java_template.business.param.update.SysMenuUpdateParam;
import com.dfg.java_template.business.param.vo.SysMenuVO;

/**
* @author zgc
* @since 2025-05-22 18:49:29
*/
public interface SysMenuService extends IService<SysMenu> {

    /**
    * 保存菜单权限
    *
    * @param sysMenuSaveParam 保存菜单权限参数
    */
    void saveSysMenu(SysMenuSaveParam sysMenuSaveParam);

    /**
    * 修改菜单权限
    *
    * @param sysMenuUpdateParam 修改菜单权限参数
    */
    void updateSysMenu(SysMenuUpdateParam sysMenuUpdateParam);

    /**
    * 查询菜单权限列表
    *
    * @param sysMenuListParam 查询菜单权限列表参数
    * @return 菜单权限VO列表
    */
    PageVO<SysMenuVO> listSysMenu(SysMenuListParam sysMenuListParam);

    /**
    * 查询菜单权限详情
    *
    * @param sysMenuQueryParam 查询菜单权限详情参数
    * @return 菜单权限VO
    */
    SysMenuVO querySysMenu(SysMenuQueryParam sysMenuQueryParam);

    /**
    * 删除菜单权限
    *
    * @param removeBaseParam 删除菜单权限参数
    */
    void removeSysMenu(RemoveBaseParam removeBaseParam);

    }
