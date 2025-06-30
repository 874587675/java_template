package com.dfg.java_template.business.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dfg.java_template.business.entity.SysRoleMenu;
import com.dfg.java_template.business.mapper.SysRoleMenuMapper;
import com.dfg.java_template.business.param.convertor.SysRoleMenuConvertor;
import com.dfg.java_template.business.param.list.SysRoleMenuListParam;
import com.dfg.java_template.business.param.page.SysRoleMenuPageParam;
import com.dfg.java_template.business.param.page.vo.PageVO;
import com.dfg.java_template.business.param.query.SysRoleMenuQueryParam;
import com.dfg.java_template.business.param.remove.RemoveBaseParam;
import com.dfg.java_template.business.param.save.SysRoleMenuSaveParam;
import com.dfg.java_template.business.param.update.SysRoleMenuUpdateParam;
import com.dfg.java_template.business.param.vo.SysRoleMenuVO;
import com.dfg.java_template.business.service.SysRoleMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
* <p>
* 角色和菜单关联表 服务实现类
* </p>
*
* @author zgc
* @since 2025-06-30 11:42:56
*/
@Service
@Slf4j
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {
    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

    /**
    * 保存角色和菜单关联
    *
    * @param sysRoleMenuSaveParam 保存角色和菜单关联参数
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveSysRoleMenu(SysRoleMenuSaveParam sysRoleMenuSaveParam){
        sysRoleMenuMapper.insert(SysRoleMenuConvertor.SAVE.saveParamToEntity(sysRoleMenuSaveParam));
    }

    /**
    * 修改角色和菜单关联
    *
    * @param sysRoleMenuUpdateParam 修改角色和菜单关联参数
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSysRoleMenu(SysRoleMenuUpdateParam sysRoleMenuUpdateParam){
        sysRoleMenuMapper.updateById(SysRoleMenuConvertor.UPDATE.updateParamToEntity(sysRoleMenuUpdateParam));
    }

    /**
    * 删除角色和菜单关联属性
    *
    * @param removeBaseParam 删除角色和菜单关联属性参数
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeSysRoleMenu(RemoveBaseParam removeBaseParam) {
        sysRoleMenuMapper.deleteById(removeBaseParam.getSerializableId());
    }

    /**
    * 前台用户查询角色和菜单关联列表
    *
    * @param sysRoleMenuListParam 查询角色和菜单关联列表参数
    * @return 角色和菜单关联VO列表
    */
    @Override
    public List<SysRoleMenuVO> frontListSysRoleMenu(SysRoleMenuListParam sysRoleMenuListParam){
        String sysRoleMenuId = sysRoleMenuListParam.getRoleMenuId();
        List<SysRoleMenu> list =list(
                new LambdaQueryWrapper<SysRoleMenu>()
                        .eq(ObjectUtil.isNotEmpty(sysRoleMenuId), SysRoleMenu::getRoleMenuId, sysRoleMenuId)
                        .orderByDesc(SysRoleMenu::getCreateTime)
        );
        return SysRoleMenuConvertor.LIST.listEntityToListVO(list);
    }

    /**
    * 前台用户分页查询角色和菜单关联列表
    *
    * @param sysRoleMenuPageParam 查询角色和菜单关联列表参数
    * @return 角色和菜单关联VO列表
    */
    @Override
    public PageVO<SysRoleMenuVO> frontPageSysRoleMenu(SysRoleMenuPageParam sysRoleMenuPageParam){
        String sysRoleMenuId = sysRoleMenuPageParam.getRoleMenuId();
        Page<SysRoleMenu> page = page(new Page<>(sysRoleMenuPageParam.getPageNo(), sysRoleMenuPageParam.getPageSize()),
                new LambdaQueryWrapper<SysRoleMenu>()
                        .eq(ObjectUtil.isNotEmpty(sysRoleMenuId), SysRoleMenu::getRoleMenuId, sysRoleMenuId)
                        .orderByDesc(SysRoleMenu::getCreateTime)
        );
        return PageVO.addPageData(page, SysRoleMenuConvertor.LIST.listEntityToListVO(page.getRecords()));
    }

    /**
    * 前台用户查询角色和菜单关联详情
    *
    * @param sysRoleMenuQueryParam 查询角色和菜单关联详情参数
    * @return 角色和菜单关联VO
    */
    @Override
    public SysRoleMenuVO frontQuerySysRoleMenu(SysRoleMenuQueryParam sysRoleMenuQueryParam){
        return SysRoleMenuConvertor.QUERY.entityToVo(sysRoleMenuMapper.selectById(sysRoleMenuQueryParam.getRoleMenuId()));
    }

    /**
    * 后台用户查询角色和菜单关联列表
    *
    * @param sysRoleMenuListParam 查询角色和菜单关联列表参数
    * @return 角色和菜单关联VO列表
    */
    @Override
    public List<SysRoleMenuVO> backListSysRoleMenu(SysRoleMenuListParam sysRoleMenuListParam){
        String sysRoleMenuId = sysRoleMenuListParam.getRoleMenuId();
        List<SysRoleMenu> list =list(
                new LambdaQueryWrapper<SysRoleMenu>()
                    .eq(ObjectUtil.isNotEmpty(sysRoleMenuId), SysRoleMenu::getRoleMenuId, sysRoleMenuId)
                    .orderByDesc(SysRoleMenu::getCreateTime)
        );
        return SysRoleMenuConvertor.LIST.listEntityToListVO(list);
    }

    /**
    * 后台用户分页查询角色和菜单关联列表
    *
    * @param sysRoleMenuPageParam 查询角色和菜单关联列表参数
    * @return 角色和菜单关联VO列表
    */
    @Override
    public PageVO<SysRoleMenuVO> backPageSysRoleMenu(SysRoleMenuPageParam sysRoleMenuPageParam){
        String sysRoleMenuId = sysRoleMenuPageParam.getRoleMenuId();
        Page<SysRoleMenu> page = page(new Page<>(sysRoleMenuPageParam.getPageNo(), sysRoleMenuPageParam.getPageSize()),
                new LambdaQueryWrapper<SysRoleMenu>()
                    .eq(ObjectUtil.isNotEmpty(sysRoleMenuId), SysRoleMenu::getRoleMenuId, sysRoleMenuId)
                    .orderByDesc(SysRoleMenu::getCreateTime)
        );
        return PageVO.addPageData(page, SysRoleMenuConvertor.LIST.listEntityToListVO(page.getRecords()));
    }

    /**
    * 后台用户查询角色和菜单关联详情
    *
    * @param sysRoleMenuQueryParam 查询角色和菜单关联详情参数
    * @return 角色和菜单关联VO
    */
    @Override
    public SysRoleMenuVO backQuerySysRoleMenu(SysRoleMenuQueryParam sysRoleMenuQueryParam){
        return SysRoleMenuConvertor.QUERY.entityToVo(sysRoleMenuMapper.selectById(sysRoleMenuQueryParam.getRoleMenuId()));
    }        
        
}
