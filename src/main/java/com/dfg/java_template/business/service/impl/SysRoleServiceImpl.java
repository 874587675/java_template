package com.dfg.java_template.business.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dfg.java_template.business.entity.SysRole;
import com.dfg.java_template.business.mapper.SysRoleMapper;
import com.dfg.java_template.business.param.convertor.SysRoleConvertor;
import com.dfg.java_template.business.param.list.SysRoleListParam;
import com.dfg.java_template.business.param.page.vo.PageVO;
import com.dfg.java_template.business.param.query.SysRoleQueryParam;
import com.dfg.java_template.business.param.remove.RemoveBaseParam;
import com.dfg.java_template.business.param.save.SysRoleSaveParam;
import com.dfg.java_template.business.param.update.SysRoleUpdateParam;
import com.dfg.java_template.business.param.vo.SysRoleVO;
import com.dfg.java_template.business.service.SysRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* <p>
* 角色信息表 服务实现类
* </p>
*
* @author zgc
* @since 2025-05-17 19:35:17
*/
@Service
@Slf4j
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
@Resource
private SysRoleMapper sysRoleMapper;

    /**
    * 保存角色信息
    *
    * @param sysRoleSaveParam 保存角色信息参数
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveSysRole(SysRoleSaveParam sysRoleSaveParam){
        sysRoleMapper.insert(SysRoleConvertor.SAVE.saveParamToEntity(sysRoleSaveParam));
    }

    /**
    * 修改角色信息
    *
    * @param sysRoleUpdateParam 修改角色信息参数
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSysRole(SysRoleUpdateParam sysRoleUpdateParam){
        sysRoleMapper.updateById(SysRoleConvertor.UPDATE.updateParamToEntity(sysRoleUpdateParam));
    }


    /**
    * 查询角色信息列表
    *
    * @param sysRoleListParam 查询角色信息列表参数
    * @return 角色信息VO列表
    */
    @Override
    public PageVO<SysRoleVO> listSysRole(SysRoleListParam sysRoleListParam){
        String sysRoleId = sysRoleListParam.getRoleId();
        Page<SysRole> page = page(new Page<>(sysRoleListParam.getPageNo(), sysRoleListParam.getPageSize()),
                new LambdaQueryWrapper<SysRole>()
                        .eq(ObjectUtil.isNotEmpty(sysRoleId), SysRole::getRoleId, sysRoleId)
                        .orderByDesc(SysRole::getCreateTime)
        );
        return PageVO.addPageData(page, SysRoleConvertor.LIST.listEntityToListVO(page.getRecords()));
    }

    /**
    * 查询角色信息详情
    *
    * @param sysRoleQueryParam 查询角色信息详情参数
    * @return 角色信息VO
    */
    @Override
    public SysRoleVO querySysRole(SysRoleQueryParam sysRoleQueryParam){
        return SysRoleConvertor.QUERY.entityToVo(sysRoleMapper.selectById(sysRoleQueryParam.getRoleId()));
    }

    /**
    * 删除角色信息属性
    *
    * @param removeBaseParam 删除角色信息属性参数
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeSysRole(RemoveBaseParam removeBaseParam) {
        sysRoleMapper.deleteById(removeBaseParam.getSerializableId());
    }

}
