package com.zy.system.zangyuesystem.service.impl;

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
}
