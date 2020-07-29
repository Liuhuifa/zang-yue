package com.zy.system.zangyuesystem.service.impl;

import com.zy.system.zangyuesystem.entity.SysRole;
import com.zy.system.zangyuesystem.dao.SysRoleDao;
import com.zy.system.zangyuesystem.service.inter.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysRole)表服务实现类
 *
 * @author makejava
 * @since 2020-07-28 16:59:01
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {
    @Resource
    private SysRoleDao sysRoleDao;

}