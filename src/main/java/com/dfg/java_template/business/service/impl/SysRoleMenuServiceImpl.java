package com.dfg.java_template.business.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dfg.java_template.business.entity.SysRoleMenu;
import com.dfg.java_template.business.mapper.SysRoleMenuMapper;
import com.dfg.java_template.business.param.convertor.SysRoleMenuConvertor;
import com.dfg.java_template.business.param.list.SysRoleMenuListParam;
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


/**
* <p>
* 角色和菜单关联表 服务实现类
* </p>
*
* @author zgc
* @since 2025-05-22 18:49:30
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
    * 查询角色和菜单关联列表
    *
    * @param sysRoleMenuListParam 查询角色和菜单关联列表参数
    * @return 角色和菜单关联VO列表
    */
    @Override
    public PageVO<SysRoleMenuVO> listSysRoleMenu(SysRoleMenuListParam sysRoleMenuListParam){
        String roleMenuId= sysRoleMenuListParam.getRoleMenuId();

        Page<SysRoleMenu> page = page(new Page<>(sysRoleMenuListParam.getPageNo(), sysRoleMenuListParam.getPageSize()),
                new LambdaQueryWrapper<SysRoleMenu>()
                        .eq(ObjectUtil.isNotEmpty(roleMenuId), SysRoleMenu::getRoleMenuId, roleMenuId)
                        .orderByDesc(SysRoleMenu::getCreateTime)
        );
        return PageVO.addPageData(page, SysRoleMenuConvertor.LIST.listEntityToListVO(page.getRecords()));
    }

    /**
    * 查询角色和菜单关联详情
    *
    * @param sysRoleMenuQueryParam 查询角色和菜单关联详情参数
    * @return 角色和菜单关联VO
    */
    @Override
    public SysRoleMenuVO querySysRoleMenu(SysRoleMenuQueryParam sysRoleMenuQueryParam){
        return SysRoleMenuConvertor.QUERY.entityToVo(sysRoleMenuMapper.selectById(sysRoleMenuQueryParam.getRoleMenuId()));
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

}
