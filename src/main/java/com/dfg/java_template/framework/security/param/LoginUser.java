package com.dfg.java_template.framework.security.param;

import cn.hutool.core.util.ObjectUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginUser implements UserDetails, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    // ================= 核心认证字段 =================
    /**
     * 用户唯一标识
     */
    private String userId;

    /**
     * 登录用户名
     */
    private String username;

    /**
     * 加密后的密码
     */
    private String bCryptPassword;

    /**
     * 账户状态（true-启用，false-禁用）
     */
    private Integer status;

    /**
     * 用户角色列表
     */
    private Collection<String> roles;
    
    /**
     * 用户权限列表
     */
    private Collection<String> permissions;

    @JsonIgnore
    private Collection<? extends GrantedAuthority> authorities;

    public LoginUser(String userId, String username, String bCryptPassword, Integer status, Collection<String> roles, Collection<String> permissions) {
        this.userId = userId;
        this.username = username;
        this.bCryptPassword = bCryptPassword;
        this.status = status;
        this.roles = roles;
        this.permissions = permissions;
    }

    // ================= 登录上下文信息 =================

    // ================= UserDetails接口实现 =================

    /**
     * 用户权限列表
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //设置角色
        List<GrantedAuthority> authorities = this.roles.stream()
                .map(role -> role.startsWith("ROLE_") ? role : "ROLE_" + role)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        
        //设置权限
        authorities.addAll(permissions.stream()
                .filter(ObjectUtil::isNotEmpty)
                .map(SimpleGrantedAuthority::new)
                .toList());

        return authorities;
    }

    /**
     * 获取用户加密后的密码
     *
     * @return 加密后的密码
     */
    @JsonIgnore
    @Override
    public String getPassword() {
        return this.bCryptPassword;
    }

    /**
     * 获取用户唯一标识
     *
     * @return 用户唯一标识
     */
    @JsonIgnore
    @Override
    public String getUsername() {
        return this.username;
    }

    /**
     * 账户是否过期
     *
     * @return true-未过期，false-已过期
     */
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账户是否锁定
     *
     * @return true-未锁定，false-已锁定
     */
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 账户凭证是否过期
     *
     * @return true-未过期，false-已过期
     */
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 账户是否启用
     *
     * @return true-启用，false-禁用
     */
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return this.status == 1;
    }

}
