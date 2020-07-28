package com.zy.zangyueweb.controller;


import com.zy.system.zangyuesystem.entity.SysMenu;
import com.zy.system.zangyuesystem.service.SysMenuService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SysMenu)表控制层
 *
 * @author makejava
 * @since 2020-07-28 16:52:45
 */
@RestController
@RequestMapping("sysMenu")
@Api(tags = "菜单/权限控制层")
public class SysMenuController {
    /**
     * 服务对象
     */
    @Resource
    private SysMenuService sysMenuService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysMenu selectOne(@RequestBody Integer id) {
        return this.sysMenuService.queryById(id);
    }

}