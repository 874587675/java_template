package com.dfg.java_template.business.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dfg.java_template.business.entity.SysUserRole;
import com.dfg.java_template.business.mapper.SysUserRoleMapper;
import com.dfg.java_template.business.param.convertor.SysUserRoleConvertor;
import com.dfg.java_template.business.param.list.SysUserRoleListParam;
import com.dfg.java_template.business.param.page.SysUserRolePageParam;
import com.dfg.java_template.business.param.page.vo.PageVO;
import com.dfg.java_template.business.param.query.SysUserRoleQueryParam;
import com.dfg.java_template.business.param.remove.RemoveBaseParam;
import com.dfg.java_template.business.param.save.SysUserRoleSaveParam;
import com.dfg.java_template.business.param.update.SysUserRoleUpdateParam;
import com.dfg.java_template.business.param.vo.SysUserRoleVO;
import com.dfg.java_template.business.service.SysUserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
* <p>
* 用户角色关联表 服务实现类
* </p>
*
* @author zgc
* @since 2025-06-30 11:42:56
*/
@Service
@Slf4j
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    /**
    * 保存用户角色关联
    *
    * @param sysUserRoleSaveParam 保存用户角色关联参数
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveSysUserRole(SysUserRoleSaveParam sysUserRoleSaveParam){
        sysUserRoleMapper.insert(SysUserRoleConvertor.SAVE.saveParamToEntity(sysUserRoleSaveParam));
    }

    /**
    * 修改用户角色关联
    *
    * @param sysUserRoleUpdateParam 修改用户角色关联参数
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSysUserRole(SysUserRoleUpdateParam sysUserRoleUpdateParam){
        sysUserRoleMapper.updateById(SysUserRoleConvertor.UPDATE.updateParamToEntity(sysUserRoleUpdateParam));
    }

    /**
    * 删除用户角色关联属性
    *
    * @param removeBaseParam 删除用户角色关联属性参数
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeSysUserRole(RemoveBaseParam removeBaseParam) {
        sysUserRoleMapper.deleteById(removeBaseParam.getSerializableId());
    }

    /**
    * 前台用户查询用户角色关联列表
    *
    * @param sysUserRoleListParam 查询用户角色关联列表参数
    * @return 用户角色关联VO列表
    */
    @Override
    public List<SysUserRoleVO> frontListSysUserRole(SysUserRoleListParam sysUserRoleListParam){
        String sysUserRoleId = sysUserRoleListParam.getUserRoleId();
        List<SysUserRole> list =list(
                new LambdaQueryWrapper<SysUserRole>()
                        .eq(ObjectUtil.isNotEmpty(sysUserRoleId), SysUserRole::getUserRoleId, sysUserRoleId)
                        .orderByDesc(SysUserRole::getCreateTime)
        );
        return SysUserRoleConvertor.LIST.listEntityToListVO(list);
    }

    /**
    * 前台用户分页查询用户角色关联列表
    *
    * @param sysUserRolePageParam 查询用户角色关联列表参数
    * @return 用户角色关联VO列表
    */
    @Override
    public PageVO<SysUserRoleVO> frontPageSysUserRole(SysUserRolePageParam sysUserRolePageParam){
        String sysUserRoleId = sysUserRolePageParam.getUserRoleId();
        Page<SysUserRole> page = page(new Page<>(sysUserRolePageParam.getPageNo(), sysUserRolePageParam.getPageSize()),
                new LambdaQueryWrapper<SysUserRole>()
                        .eq(ObjectUtil.isNotEmpty(sysUserRoleId), SysUserRole::getUserRoleId, sysUserRoleId)
                        .orderByDesc(SysUserRole::getCreateTime)
        );
        return PageVO.addPageData(page, SysUserRoleConvertor.LIST.listEntityToListVO(page.getRecords()));
    }

    /**
    * 前台用户查询用户角色关联详情
    *
    * @param sysUserRoleQueryParam 查询用户角色关联详情参数
    * @return 用户角色关联VO
    */
    @Override
    public SysUserRoleVO frontQuerySysUserRole(SysUserRoleQueryParam sysUserRoleQueryParam){
        return SysUserRoleConvertor.QUERY.entityToVo(sysUserRoleMapper.selectById(sysUserRoleQueryParam.getUserRoleId()));
    }

    /**
    * 后台用户查询用户角色关联列表
    *
    * @param sysUserRoleListParam 查询用户角色关联列表参数
    * @return 用户角色关联VO列表
    */
    @Override
    public List<SysUserRoleVO> backListSysUserRole(SysUserRoleListParam sysUserRoleListParam){
        String sysUserRoleId = sysUserRoleListParam.getUserRoleId();
        List<SysUserRole> list =list(
                new LambdaQueryWrapper<SysUserRole>()
                    .eq(ObjectUtil.isNotEmpty(sysUserRoleId), SysUserRole::getUserRoleId, sysUserRoleId)
                    .orderByDesc(SysUserRole::getCreateTime)
        );
        return SysUserRoleConvertor.LIST.listEntityToListVO(list);
    }

    /**
    * 后台用户分页查询用户角色关联列表
    *
    * @param sysUserRolePageParam 查询用户角色关联列表参数
    * @return 用户角色关联VO列表
    */
    @Override
    public PageVO<SysUserRoleVO> backPageSysUserRole(SysUserRolePageParam sysUserRolePageParam){
        String sysUserRoleId = sysUserRolePageParam.getUserRoleId();
        Page<SysUserRole> page = page(new Page<>(sysUserRolePageParam.getPageNo(), sysUserRolePageParam.getPageSize()),
                new LambdaQueryWrapper<SysUserRole>()
                    .eq(ObjectUtil.isNotEmpty(sysUserRoleId), SysUserRole::getUserRoleId, sysUserRoleId)
                    .orderByDesc(SysUserRole::getCreateTime)
        );
        return PageVO.addPageData(page, SysUserRoleConvertor.LIST.listEntityToListVO(page.getRecords()));
    }

    /**
    * 后台用户查询用户角色关联详情
    *
    * @param sysUserRoleQueryParam 查询用户角色关联详情参数
    * @return 用户角色关联VO
    */
    @Override
    public SysUserRoleVO backQuerySysUserRole(SysUserRoleQueryParam sysUserRoleQueryParam){
        return SysUserRoleConvertor.QUERY.entityToVo(sysUserRoleMapper.selectById(sysUserRoleQueryParam.getUserRoleId()));
    }        
        
}
