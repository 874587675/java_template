package com.dfg.java_template.business.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dfg.java_template.business.entity.SysUser;
import com.dfg.java_template.business.mapper.SysUserMapper;
import com.dfg.java_template.business.param.convertor.SysUserConvertor;
import com.dfg.java_template.business.param.list.SysUserListParam;
import com.dfg.java_template.business.param.page.SysUserPageParam;
import com.dfg.java_template.business.param.page.vo.PageVO;
import com.dfg.java_template.business.param.query.SysUserQueryParam;
import com.dfg.java_template.business.param.remove.RemoveBaseParam;
import com.dfg.java_template.business.param.save.SysUserSaveParam;
import com.dfg.java_template.business.param.update.SysUserUpdateParam;
import com.dfg.java_template.business.param.vo.SysUserVO;
import com.dfg.java_template.business.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
* <p>
* 后台用户表 服务实现类
* </p>
*
* @author zgc
* @since 2025-06-30 11:42:56
*/
@Service
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    /**
    * 保存后台用户
    *
    * @param sysUserSaveParam 保存后台用户参数
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveSysUser(SysUserSaveParam sysUserSaveParam){
        sysUserMapper.insert(SysUserConvertor.SAVE.saveParamToEntity(sysUserSaveParam));
    }

    /**
    * 修改后台用户
    *
    * @param sysUserUpdateParam 修改后台用户参数
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSysUser(SysUserUpdateParam sysUserUpdateParam){
        sysUserMapper.updateById(SysUserConvertor.UPDATE.updateParamToEntity(sysUserUpdateParam));
    }

    /**
    * 删除后台用户属性
    *
    * @param removeBaseParam 删除后台用户属性参数
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeSysUser(RemoveBaseParam removeBaseParam) {
        sysUserMapper.deleteById(removeBaseParam.getSerializableId());
    }

    /**
    * 前台用户查询后台用户列表
    *
    * @param sysUserListParam 查询后台用户列表参数
    * @return 后台用户VO列表
    */
    @Override
    public List<SysUserVO> frontListSysUser(SysUserListParam sysUserListParam){
        String sysUserId = sysUserListParam.getUserId();
        List<SysUser> list =list(
                new LambdaQueryWrapper<SysUser>()
                        .eq(ObjectUtil.isNotEmpty(sysUserId), SysUser::getUserId, sysUserId)
                        .orderByDesc(SysUser::getCreateTime)
        );
        return SysUserConvertor.LIST.listEntityToListVO(list);
    }

    /**
    * 前台用户分页查询后台用户列表
    *
    * @param sysUserPageParam 查询后台用户列表参数
    * @return 后台用户VO列表
    */
    @Override
    public PageVO<SysUserVO> frontPageSysUser(SysUserPageParam sysUserPageParam){
        String sysUserId = sysUserPageParam.getUserId();
        Page<SysUser> page = page(new Page<>(sysUserPageParam.getPageNo(), sysUserPageParam.getPageSize()),
                new LambdaQueryWrapper<SysUser>()
                        .eq(ObjectUtil.isNotEmpty(sysUserId), SysUser::getUserId, sysUserId)
                        .orderByDesc(SysUser::getCreateTime)
        );
        return PageVO.addPageData(page, SysUserConvertor.LIST.listEntityToListVO(page.getRecords()));
    }

    /**
    * 前台用户查询后台用户详情
    *
    * @param sysUserQueryParam 查询后台用户详情参数
    * @return 后台用户VO
    */
    @Override
    public SysUserVO frontQuerySysUser(SysUserQueryParam sysUserQueryParam){
        return SysUserConvertor.QUERY.entityToVo(sysUserMapper.selectById(sysUserQueryParam.getUserId()));
    }

    /**
    * 后台用户查询后台用户列表
    *
    * @param sysUserListParam 查询后台用户列表参数
    * @return 后台用户VO列表
    */
    @Override
    public List<SysUserVO> backListSysUser(SysUserListParam sysUserListParam){
        String sysUserId = sysUserListParam.getUserId();
        List<SysUser> list =list(
                new LambdaQueryWrapper<SysUser>()
                    .eq(ObjectUtil.isNotEmpty(sysUserId), SysUser::getUserId, sysUserId)
                    .orderByDesc(SysUser::getCreateTime)
        );
        return SysUserConvertor.LIST.listEntityToListVO(list);
    }

    /**
    * 后台用户分页查询后台用户列表
    *
    * @param sysUserPageParam 查询后台用户列表参数
    * @return 后台用户VO列表
    */
    @Override
    public PageVO<SysUserVO> backPageSysUser(SysUserPageParam sysUserPageParam){
        String sysUserId = sysUserPageParam.getUserId();
        Page<SysUser> page = page(new Page<>(sysUserPageParam.getPageNo(), sysUserPageParam.getPageSize()),
                new LambdaQueryWrapper<SysUser>()
                    .eq(ObjectUtil.isNotEmpty(sysUserId), SysUser::getUserId, sysUserId)
                    .orderByDesc(SysUser::getCreateTime)
        );
        return PageVO.addPageData(page, SysUserConvertor.LIST.listEntityToListVO(page.getRecords()));
    }

    /**
    * 后台用户查询后台用户详情
    *
    * @param sysUserQueryParam 查询后台用户详情参数
    * @return 后台用户VO
    */
    @Override
    public SysUserVO backQuerySysUser(SysUserQueryParam sysUserQueryParam){
        return SysUserConvertor.QUERY.entityToVo(sysUserMapper.selectById(sysUserQueryParam.getUserId()));
    }        
        
}
