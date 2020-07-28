package com.zy.core.zangyuecore.security.phone;

import cn.hutool.core.lang.Assert;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <p>
 * 手机号密码登录
 * </p>
 *
 * @author lhf
 * @since 2020/7/28 11:28
 */
@Component
public class PhoneProvider implements AuthenticationProvider {

    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource(name = "phoneUserDetailsService")
    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String phone = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        UserDetails userDetails = userDetailsService.loadUserByUsername(phone);
        System.out.println(userDetails);
        if (userDetails == null) {
            throw new UsernameNotFoundException("用户未找到");
        }
        //密码比对
        Assert.notBlank(phone, "手机号不能为空");
        Assert.notBlank(password, "密码不能为空");

        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("用户名或者密码错误");
        }

        if (!userDetails.isAccountNonExpired()) {
            throw new AccountExpiredException("凭证过期");
        }

        if (!userDetails.isAccountNonLocked()) {
            throw new LockedException("用户被锁定");
        }
        return new PhoneToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (PhoneToken.class.isAssignableFrom(authentication));
    }
}
