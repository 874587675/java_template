package com.dfg.java_template.framework.security.service.login;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dfg.java_template.business.entity.SysUser;
import com.dfg.java_template.business.mapper.SysMenuMapper;
import com.dfg.java_template.business.mapper.SysRoleMapper;
import com.dfg.java_template.business.mapper.SysUserMapper;
import com.dfg.java_template.business.param.vo.SysUserVO;
import com.dfg.java_template.framework.security.param.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class BackendUserDetailsService implements UserDetailsService {
    @Resource
    private PasswordService passwordService;
    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private SysRoleMapper sysRoleMapper;
    @Resource
    private SysMenuMapper sysMenuMapper;

    /**
     * 根据用户名加载用户信息
     *
     * @param username 用户名
     * @return UserDetails 用户信息
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        //根据用户名查询用户
        SysUser sysUser = sysUserMapper.selectOne(
                new LambdaQueryWrapper<SysUser>()
                        .eq(SysUser::getUserName, username)
                        .last("limit 1"));
        SysUserVO sysUserVO = new SysUserVO();
        BeanUtils.copyProperties(sysUser, sysUserVO);
        //验证密码
        passwordService.validatePassword(sysUserVO);
        //返回用户信息
        return createLoginUser(sysUserVO);
    }

    /**
     * 创建登录用户
     *
     * @param sysUserVO 用户信息
     * @return UserDetails 登录用户信息
     */
    public UserDetails createLoginUser(SysUserVO sysUserVO) {
        String userId = sysUserVO.getUserId();
        //查询后台用户角色
        List<String> roles = sysRoleMapper.selectRoleByUserId(userId);
        //查询后台用户权限
        List<String> permissions = sysMenuMapper.selectMenuByUserId(userId);
        return new LoginUser(sysUserVO.getUserId(), sysUserVO.getUserName(), sysUserVO.getPassword(), sysUserVO.getStatus(), roles, permissions);
    }
}
