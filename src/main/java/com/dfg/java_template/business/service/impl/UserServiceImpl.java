package com.dfg.java_template.business.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dfg.java_template.business.entity.User;
import com.dfg.java_template.business.mapper.UserMapper;
import com.dfg.java_template.business.param.convertor.UserConvertor;
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
import java.util.Date;
import java.util.HashMap;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author zgc
 * @since 2025-05-15 15:13:18
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
    public void saveUser(UserSaveParam userSaveParam) {
        userMapper.insert(UserConvertor.SAVE.saveParamToEntity(userSaveParam));
    }

    /**
     * 修改用户信息
     *
     * @param userUpdateParam 修改用户信息参数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUser(UserUpdateParam userUpdateParam) {
        userMapper.updateById(UserConvertor.UPDATE.updateParamToEntity(userUpdateParam));
    }

    /**
     * 分页查询用户信息
     *
     * @param userPageParam 分页查询用户信息参数
     * @return 用户信息VO分页对象
     */
    @Override
    public PageVO<UserVO> pageUser(UserPageParam userPageParam) {
        String userId = userPageParam.getUserId();
        Page<User> page = page(new Page<>(userPageParam.getPageNo(), userPageParam.getPageSize()), 
                new LambdaQueryWrapper<User>()
                        .eq(ObjectUtil.isNotEmpty(userId), User::getUserId, userId)
                        .orderByDesc(User::getCreateTime));
        return PageVO.addPageData(page, UserConvertor.LIST.listEntityToListVO(page.getRecords()));
    }

    /**
     * 查询用户信息详情
     *
     * @param userQueryParam 查询用户信息详情参数
     * @return 用户信息VO
     */
    @Override
    public UserVO queryUser(UserQueryParam userQueryParam) {
        return UserConvertor.QUERY.entityToVo(userMapper.selectById(userQueryParam.getUserId()));
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
     * 登录用户
     *
     * @param loginBody 登录参数
     * @return 用户信息VO
     */
    @Override
    public String loginUser(LoginBody loginBody) {
        String username = loginBody.getUsername();
        String password = loginBody.getPassword();

        // 这里的AuthenticationContextHolder.setContext(authenticationToken)是为了在后续的操作中可以获取到当前登录用户的信息
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        AuthenticationContextHolder.setContext(authenticationToken);
        // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
        Authentication authentication = frontendAuthenticationManager.authenticate(authenticationToken);

        LoginUser loginUser = (LoginUser) authentication.getPrincipal();

        String userId = loginUser.getUserId();
        //更新最后登录时间
        userMapper.update(new LambdaUpdateWrapper<User>().eq(User::getUserId, userId).set(User::getLastLoginTime, new Date())); 

        Map<String, Object> claims = new HashMap<>();

        claims.put("userId", userId);
        claims.put("username", loginUser.getUsername());

        int expireTime = tokenService.getTokenParam().getExpireTime();

        redisCache.setCacheObject(CacheConstants.LOGIN_USER + userId, loginUser, expireTime, TimeUnit.MINUTES);

        return tokenService.generateToken(userId, claims);
    }
}
