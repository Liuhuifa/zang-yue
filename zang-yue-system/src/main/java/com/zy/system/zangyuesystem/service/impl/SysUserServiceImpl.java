package com.zy.system.zangyuesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zy.system.zangyuesystem.entity.SysUser;
import com.zy.system.zangyuesystem.mapper.SysUserDao;
import com.zy.system.zangyuesystem.service.inter.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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


    @Override
    public int insert(SysUser sysUser) {
        return sysUserDao.insert(sysUser);
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
