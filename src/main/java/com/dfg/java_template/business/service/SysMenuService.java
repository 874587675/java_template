package com.dfg.java_template.business.service;

import com.dfg.java_template.business.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dfg.java_template.business.param.page.vo.PageVO;
import com.dfg.java_template.business.param.save.SysMenuSaveParam;
import com.dfg.java_template.business.param.update.SysMenuUpdateParam;
import com.dfg.java_template.business.param.list.SysMenuListParam;
import com.dfg.java_template.business.param.query.SysMenuQueryParam;
import com.dfg.java_template.business.param.remove.RemoveBaseParam;
import com.dfg.java_template.business.param.page.SysMenuPageParam;
import com.dfg.java_template.business.param.vo.SysMenuVO;
import java.util.List;
/**
* @author zgc
* @since 2025-06-30 11:38:23
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
    * 删除菜单权限
    *
    * @param removeBaseParam 删除菜单权限参数
    */
    void removeSysMenu(RemoveBaseParam removeBaseParam);

    /**
    * 前台用户查询菜单权限列表
    *
    * @param sysMenuListParam 查询菜单权限列表参数
    * @return 菜单权限VO列表
    */
    List<SysMenuVO> frontListSysMenu(SysMenuListParam sysMenuListParam);
    
    /**
    * 前台用户分页查询菜单权限列表
    *
    * @param sysMenuPageParam 查询菜单权限列表参数
    * @return 菜单权限VO列表
    */
    PageVO<SysMenuVO> frontPageSysMenu(SysMenuPageParam sysMenuPageParam);

    /**
    * 前台用户查询菜单权限详情
    *
    * @param sysMenuQueryParam 查询菜单权限详情参数
    * @return 菜单权限VO
    */
    SysMenuVO frontQuerySysMenu(SysMenuQueryParam sysMenuQueryParam);
        
    /**
    * 后台用户查询菜单权限列表
    *
    * @param sysMenuListParam 查询菜单权限列表参数
    * @return 菜单权限VO列表
    */
    List<SysMenuVO> backListSysMenu(SysMenuListParam sysMenuListParam);

    /**
    * 后台用户分页查询菜单权限列表
    *
    * @param sysMenuPageParam 查询菜单权限列表参数
    * @return 菜单权限VO列表
    */
    PageVO<SysMenuVO> backPageSysMenu(SysMenuPageParam sysMenuPageParam);

    /**
    * 后台用户查询菜单权限详情
    *
    * @param sysMenuQueryParam 查询菜单权限详情参数
    * @return 菜单权限VO
    */
    SysMenuVO backQuerySysMenu(SysMenuQueryParam sysMenuQueryParam);        
}
