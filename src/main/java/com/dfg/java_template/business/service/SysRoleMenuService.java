package com.dfg.java_template.business.service;

import com.dfg.java_template.business.entity.SysRoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dfg.java_template.business.param.page.vo.PageVO;
import com.dfg.java_template.business.param.save.SysRoleMenuSaveParam;
import com.dfg.java_template.business.param.update.SysRoleMenuUpdateParam;
import com.dfg.java_template.business.param.list.SysRoleMenuListParam;
import com.dfg.java_template.business.param.query.SysRoleMenuQueryParam;
import com.dfg.java_template.business.param.remove.RemoveBaseParam;
import com.dfg.java_template.business.param.page.SysRoleMenuPageParam;
import com.dfg.java_template.business.param.vo.SysRoleMenuVO;
import java.util.List;
/**
* @author zgc
* @since 2025-06-30 11:42:56
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
    * 删除角色和菜单关联
    *
    * @param removeBaseParam 删除角色和菜单关联参数
    */
    void removeSysRoleMenu(RemoveBaseParam removeBaseParam);

    /**
    * 前台用户查询角色和菜单关联列表
    *
    * @param sysRoleMenuListParam 查询角色和菜单关联列表参数
    * @return 角色和菜单关联VO列表
    */
    List<SysRoleMenuVO> frontListSysRoleMenu(SysRoleMenuListParam sysRoleMenuListParam);
    
    /**
    * 前台用户分页查询角色和菜单关联列表
    *
    * @param sysRoleMenuPageParam 查询角色和菜单关联列表参数
    * @return 角色和菜单关联VO列表
    */
    PageVO<SysRoleMenuVO> frontPageSysRoleMenu(SysRoleMenuPageParam sysRoleMenuPageParam);

    /**
    * 前台用户查询角色和菜单关联详情
    *
    * @param sysRoleMenuQueryParam 查询角色和菜单关联详情参数
    * @return 角色和菜单关联VO
    */
    SysRoleMenuVO frontQuerySysRoleMenu(SysRoleMenuQueryParam sysRoleMenuQueryParam);
        
    /**
    * 后台用户查询角色和菜单关联列表
    *
    * @param sysRoleMenuListParam 查询角色和菜单关联列表参数
    * @return 角色和菜单关联VO列表
    */
    List<SysRoleMenuVO> backListSysRoleMenu(SysRoleMenuListParam sysRoleMenuListParam);

    /**
    * 后台用户分页查询角色和菜单关联列表
    *
    * @param sysRoleMenuPageParam 查询角色和菜单关联列表参数
    * @return 角色和菜单关联VO列表
    */
    PageVO<SysRoleMenuVO> backPageSysRoleMenu(SysRoleMenuPageParam sysRoleMenuPageParam);

    /**
    * 后台用户查询角色和菜单关联详情
    *
    * @param sysRoleMenuQueryParam 查询角色和菜单关联详情参数
    * @return 角色和菜单关联VO
    */
    SysRoleMenuVO backQuerySysRoleMenu(SysRoleMenuQueryParam sysRoleMenuQueryParam);        
}
