package com.dfg.java_template.business.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dfg.java_template.business.entity.User;
import com.dfg.java_template.business.mapper.UserMapper;
import com.dfg.java_template.business.param.convertor.UserConvertor;
import com.dfg.java_template.business.param.list.UserListParam;
import com.dfg.java_template.business.param.page.UserPageParam;
import com.dfg.java_template.business.param.page.vo.PageVO;
import com.dfg.java_template.business.param.query.UserQueryParam;
import com.dfg.java_template.business.param.remove.RemoveBaseParam;
import com.dfg.java_template.business.param.save.UserSaveParam;
import com.dfg.java_template.business.param.update.UserUpdateParam;
import com.dfg.java_template.business.param.vo.UserVO;
import com.dfg.java_template.business.service.UserService;
import com.dfg.java_template.common.constant.CacheConstants;
import com.dfg.java_template.framework.redis.RedisCache;
import com.dfg.java_template.framework.security.constant.LoginRole;
import com.dfg.java_template.framework.security.core.AuthenticationContextHolder;
import com.dfg.java_template.framework.security.param.LoginBody;
import com.dfg.java_template.framework.security.param.LoginUser;
import com.dfg.java_template.framework.security.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

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

    @Resource(name = "frontendAuthenticationManager")
    private AuthenticationManager frontendAuthenticationManager;

    @Resource
    private TokenService tokenService;

    @Resource
    private RedisCache redisCache;

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

    @Override
    public String loginUser(LoginBody loginBody) {
        String username = loginBody.getUsername();
        String password = loginBody.getPassword();

        // 这里的AuthenticationContextHolder.setContext(authenticationToken)是为了在后续的操作中可以获取到当前登录用户的信息
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        AuthenticationContextHolder.setFrontContext(authenticationToken);
        // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
        Authentication authentication = frontendAuthenticationManager.authenticate(authenticationToken);

        LoginUser loginUser = (LoginUser) authentication.getPrincipal();

        String userId = loginUser.getUserId();
        //更新最后登录时间
        userMapper.update(new LambdaUpdateWrapper<User>().eq(User::getUserId, userId).set(User::getLastLoginTime, new Date()));

        Map<String, Object> claims = new HashMap<>();

        claims.put("userId", userId);
        claims.put("username", loginUser.getUsername());
        claims.put("role", LoginRole.FRONT_ROLE.getCode());

        int expireTime = tokenService.getTokenParam().getExpireTime();

        redisCache.setCacheObject(CacheConstants.LOGIN_USER + CacheConstants.FRONT_KEY + userId, loginUser, expireTime, TimeUnit.MINUTES);

        return tokenService.generateToken(userId, claims);
    }

    @Override
    public void addUser() {
//        //批量构建User类，我要测试批量插入
//        List<User> list = new ArrayList<>();
//        for (int i = 0; i < 3; i++) {
//            User user = new User();
//            user.setUserName("user" + i);
//            user.setPassword("password" + i);
//            user.setSex(i % 2);
//            user.setNickName("nickName" + i);
//            user.setAvatar("avatar" + i);
//            user.setBirthday(new Date());
//            user.setPhone("phone" + i);
//            user.setStatus(i % 2);
//            list.add(user);
//        }
//        userMapper.insertBatchSomeColumn(list);
        System.out.println(AuthenticationContextHolder.getFrontUserId());
    }
}
