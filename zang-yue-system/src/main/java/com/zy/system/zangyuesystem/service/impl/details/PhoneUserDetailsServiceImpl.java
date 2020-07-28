package com.zy.system.zangyuesystem.service.impl.details;

import com.zy.system.zangyuesystem.dto.SysUserDetails;
import com.zy.system.zangyuesystem.dao.SysUserDao;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/7/28 15:42
 */
@Component("phoneUserDetailsService")
public class PhoneUserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private SysUserDao sysUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Map<String, String> map = new HashMap<>(1);
        map.put("phone", username);
        SysUserDetails login = sysUserDao.login(map);
        if (login == null) {
            throw new UsernameNotFoundException("用户名未找到");
        }
        return login;
    }
}
