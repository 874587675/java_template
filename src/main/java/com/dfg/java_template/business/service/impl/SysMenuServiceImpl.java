package com.dfg.java_template.business.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dfg.java_template.business.entity.SysMenu;
import com.dfg.java_template.business.mapper.SysMenuMapper;
import com.dfg.java_template.business.param.convertor.SysMenuConvertor;
import com.dfg.java_template.business.param.list.SysMenuListParam;
import com.dfg.java_template.business.param.page.vo.PageVO;
import com.dfg.java_template.business.param.query.SysMenuQueryParam;
import com.dfg.java_template.business.param.remove.RemoveBaseParam;
import com.dfg.java_template.business.param.save.SysMenuSaveParam;
import com.dfg.java_template.business.param.update.SysMenuUpdateParam;
import com.dfg.java_template.business.param.vo.SysMenuVO;
import com.dfg.java_template.business.service.SysMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
* <p>
* 菜单权限表 服务实现类
* </p>
*
* @author zgc
* @since 2025-05-22 18:49:29
*/
@Service
@Slf4j
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
@Resource
private SysMenuMapper sysMenuMapper;

    /**
    * 保存菜单权限
    *
    * @param sysMenuSaveParam 保存菜单权限参数
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveSysMenu(SysMenuSaveParam sysMenuSaveParam){
        sysMenuMapper.insert(SysMenuConvertor.SAVE.saveParamToEntity(sysMenuSaveParam));
    }

    /**
    * 修改菜单权限
    *
    * @param sysMenuUpdateParam 修改菜单权限参数
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSysMenu(SysMenuUpdateParam sysMenuUpdateParam){
        sysMenuMapper.updateById(SysMenuConvertor.UPDATE.updateParamToEntity(sysMenuUpdateParam));
    }


    /**
    * 查询菜单权限列表
    *
    * @param sysMenuListParam 查询菜单权限列表参数
    * @return 菜单权限VO列表
    */
    @Override
    public PageVO<SysMenuVO> listSysMenu(SysMenuListParam sysMenuListParam){
        String sysMenuId = sysMenuListParam.getMenuId();
        Page<SysMenu> page = page(new Page<>(sysMenuListParam.getPageNo(), sysMenuListParam.getPageSize()),
                new LambdaQueryWrapper<SysMenu>()
                        .eq(ObjectUtil.isNotEmpty(sysMenuId), SysMenu::getMenuId, sysMenuId)
                        .orderByDesc(SysMenu::getCreateTime)
        );
        return PageVO.addPageData(page, SysMenuConvertor.LIST.listEntityToListVO(page.getRecords()));
    }

    /**
    * 查询菜单权限详情
    *
    * @param sysMenuQueryParam 查询菜单权限详情参数
    * @return 菜单权限VO
    */
    @Override
    public SysMenuVO querySysMenu(SysMenuQueryParam sysMenuQueryParam){
        return SysMenuConvertor.QUERY.entityToVo(sysMenuMapper.selectById(sysMenuQueryParam.getMenuId()));
    }

    /**
    * 删除菜单权限属性
    *
    * @param removeBaseParam 删除菜单权限属性参数
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeSysMenu(RemoveBaseParam removeBaseParam) {
        sysMenuMapper.deleteById(removeBaseParam.getSerializableId());
    }

}
