package com.zy.system.zangyuesystem.service.impl;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zy.common.zangyuecommon.exception.PhoneExistException;
import com.zy.common.zangyuecommon.exception.UsernameExistException;
import com.zy.common.zangyuecommon.util.BeanUtil;
import com.zy.common.zangyuecommon.util.EntityUtil;
import com.zy.system.zangyuesystem.dao.SysUserDao;
import com.zy.system.zangyuesystem.dao.SysUserRoleDao;
import com.zy.system.zangyuesystem.dto.SysUserDTO;
import com.zy.system.zangyuesystem.entity.SysUser;
import com.zy.system.zangyuesystem.entity.SysUserRole;
import com.zy.system.zangyuesystem.service.inter.SysUserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/7/18$ 8:38$
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserDao sysUserDao;
    @Resource
    private SysUserRoleDao sysUserRoleDao;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(SysUserDTO sysUser) throws PhoneExistException, UsernameExistException {

        if (this.phoneExist(sysUser.getPhone())) {
            throw new PhoneExistException("手机号已存在");
        }
        if (this.usernameExist(sysUser.getUsername())) {
            throw new UsernameExistException("用户名已存在");
        }

        PasswordEncoder passwordEncoder = BeanUtil.getBean(PasswordEncoder.class);
        sysUser.setPassword(passwordEncoder.encode(sysUser.getPassword()));
        //添加用户
        SysUser user = EntityUtil.transformation(sysUser, SysUser.class);
        sysUserDao.insert(user);
        //添加角色
        Assert.notEmpty(sysUser.getRoles(), "角色必须选择");
        List<SysUserRole> userRoles = sysUser.getRoles().stream().map(item -> new SysUserRole(user.getId(), item)).collect(Collectors.toList());
        sysUserRoleDao.insert(userRoles);
        return 1;
    }

    @Override
    public boolean usernameExist(String username) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("username", username);
        Integer count = sysUserDao.selectCount(queryWrapper);
        return count > 0;
    }

    @Override
    public boolean phoneExist(String phone) {
        SysUser sysUser = new SysUser();
        sysUser.setPhone(phone);
        Integer count = sysUserDao.selectCount(new QueryWrapper<>(sysUser));
        return count > 0;
    }
}
