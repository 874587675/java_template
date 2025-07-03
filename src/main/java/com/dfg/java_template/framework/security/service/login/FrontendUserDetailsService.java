package com.dfg.java_template.framework.security.service.login;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dfg.java_template.business.entity.User;
import com.dfg.java_template.business.mapper.UserMapper;
import com.dfg.java_template.business.param.convertor.UserConvertor;
import com.dfg.java_template.business.param.vo.UserVO;
import com.dfg.java_template.framework.security.param.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class FrontendUserDetailsService implements UserDetailsService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private PasswordService passwordService;

    /**
     * 根据用户名加载用户信息
     *
     * @param username 用户名
     * @return UserDetails 用户信息
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        //根据用户名查询用户
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUserName, username).last("limit 1"));
        UserVO userVO = UserConvertor.QUERY.entityToVo(user);
        //验证密码
        passwordService.validatePassword(userVO);
        //返回用户信息
        return createLoginUser(userVO);
    }

    /**
     * 创建登录用户
     *
     * @param userVO 用户信息
     * @return UserDetails 登录用户信息
     */
    public UserDetails createLoginUser(UserVO userVO) {
        Set<String> roles = new HashSet<>();
        List<String> permissions = new ArrayList<>();
        return new LoginUser(userVO.getUserId(), userVO.getUserName(), userVO.getPassword(), userVO.getStatus(), roles, permissions);
    }
}
