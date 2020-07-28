package com.zy.system.zangyuesystem.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * sys_user
 *
 * @author lhf
 */
@Data
public class SysUserDetails implements UserDetails, Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实名字
     */
    private String realName;

    /**
     * 头像地址
     */
    private String headImg;

    /**
     * 是否锁定
     */
    private Integer isLock;

    /**
     * 用户的所有角色
     */
    private List<SysRoleDTO> roles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //TODO 权限注入
        return Arrays.<GrantedAuthority>asList(new SimpleGrantedAuthority("ROOT"), new SimpleGrantedAuthority("ADMIN"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isLock == 0;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}