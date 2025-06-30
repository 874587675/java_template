package com.dfg.java_template.business.service.impl;

import com.dfg.java_template.business.entity.User;
import com.dfg.java_template.business.mapper.UserMapper;
import com.dfg.java_template.business.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dfg.java_template.business.param.vo.UserVO;
import com.dfg.java_template.business.param.page.vo.PageVO;
import com.dfg.java_template.business.param.save.UserSaveParam;
import com.dfg.java_template.business.param.update.UserUpdateParam;
import com.dfg.java_template.business.param.list.UserListParam;
import com.dfg.java_template.business.param.query.UserQueryParam;
import com.dfg.java_template.business.param.remove.RemoveBaseParam;
import com.dfg.java_template.business.param.page.UserPageParam;
import cn.hutool.core.util.ObjectUtil;
import javax.annotation.Resource;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.transaction.annotation.Transactional;
import com.dfg.java_template.business.param.convertor.UserConvertor;
import java.util.List;

/**
* <p>
* 用户信息表 服务实现类
* </p>
*
* @author zgc
* @since 2025-06-30 11:42:56
*/
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
    * 保存用户信息
    *
    * @param userSaveParam 保存用户信息参数
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveUser(UserSaveParam userSaveParam){
        userMapper.insert(UserConvertor.SAVE.saveParamToEntity(userSaveParam));
    }

    /**
    * 修改用户信息
    *
    * @param userUpdateParam 修改用户信息参数
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUser(UserUpdateParam userUpdateParam){
        userMapper.updateById(UserConvertor.UPDATE.updateParamToEntity(userUpdateParam));
    }

    /**
    * 删除用户信息属性
    *
    * @param removeBaseParam 删除用户信息属性参数
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeUser(RemoveBaseParam removeBaseParam) {
        userMapper.deleteById(removeBaseParam.getSerializableId());
    }

    /**
    * 前台用户查询用户信息列表
    *
    * @param userListParam 查询用户信息列表参数
    * @return 用户信息VO列表
    */
    @Override
    public List<UserVO> frontListUser(UserListParam userListParam){
        String userId = userListParam.getUserId();
        List<User> list =list(
                new LambdaQueryWrapper<User>()
                        .eq(ObjectUtil.isNotEmpty(userId), User::getUserId, userId)
                        .orderByDesc(User::getCreateTime)
        );
        return UserConvertor.LIST.listEntityToListVO(list);
    }

    /**
    * 前台用户分页查询用户信息列表
    *
    * @param userPageParam 查询用户信息列表参数
    * @return 用户信息VO列表
    */
    @Override
    public PageVO<UserVO> frontPageUser(UserPageParam userPageParam){
        String userId = userPageParam.getUserId();
        Page<User> page = page(new Page<>(userPageParam.getPageNo(), userPageParam.getPageSize()),
                new LambdaQueryWrapper<User>()
                        .eq(ObjectUtil.isNotEmpty(userId), User::getUserId, userId)
                        .orderByDesc(User::getCreateTime)
        );
        return PageVO.addPageData(page, UserConvertor.LIST.listEntityToListVO(page.getRecords()));
    }

    /**
    * 前台用户查询用户信息详情
    *
    * @param userQueryParam 查询用户信息详情参数
    * @return 用户信息VO
    */
    @Override
    public UserVO frontQueryUser(UserQueryParam userQueryParam){
        return UserConvertor.QUERY.entityToVo(userMapper.selectById(userQueryParam.getUserId()));
    }

    /**
    * 后台用户查询用户信息列表
    *
    * @param userListParam 查询用户信息列表参数
    * @return 用户信息VO列表
    */
    @Override
    public List<UserVO> backListUser(UserListParam userListParam){
        String userId = userListParam.getUserId();
        List<User> list =list(
                new LambdaQueryWrapper<User>()
                    .eq(ObjectUtil.isNotEmpty(userId), User::getUserId, userId)
                    .orderByDesc(User::getCreateTime)
        );
        return UserConvertor.LIST.listEntityToListVO(list);
    }

    /**
    * 后台用户分页查询用户信息列表
    *
    * @param userPageParam 查询用户信息列表参数
    * @return 用户信息VO列表
    */
    @Override
    public PageVO<UserVO> backPageUser(UserPageParam userPageParam){
        String userId = userPageParam.getUserId();
        Page<User> page = page(new Page<>(userPageParam.getPageNo(), userPageParam.getPageSize()),
                new LambdaQueryWrapper<User>()
                    .eq(ObjectUtil.isNotEmpty(userId), User::getUserId, userId)
                    .orderByDesc(User::getCreateTime)
        );
        return PageVO.addPageData(page, UserConvertor.LIST.listEntityToListVO(page.getRecords()));
    }

    /**
    * 后台用户查询用户信息详情
    *
    * @param userQueryParam 查询用户信息详情参数
    * @return 用户信息VO
    */
    @Override
    public UserVO backQueryUser(UserQueryParam userQueryParam){
        return UserConvertor.QUERY.entityToVo(userMapper.selectById(userQueryParam.getUserId()));
    }        
        
}
