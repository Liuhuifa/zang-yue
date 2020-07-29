package com.zy.system.zangyuesystem.service.impl;

import com.zy.system.zangyuesystem.entity.SysMenu;
import com.zy.system.zangyuesystem.dao.SysMenuDao;
import com.zy.system.zangyuesystem.service.inter.SysMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysMenu)表服务实现类
 *
 * @author makejava
 * @since 2020-07-28 16:51:26
 */
@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {
    @Resource
    private SysMenuDao sysMenuDao;


}