package com.zy.zangyueweb.controller;

import com.zy.system.zangyuesystem.service.inter.SysRoleService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (SysRole)表控制层
 *
 * @author makejava
 * @since 2020-07-28 16:57:27
 */
@RestController
@RequestMapping("sysRole")
@Api(tags = "角色管理层")
public class SysRoleController {
    /**
     * 服务对象
     */
    @Resource
    private SysRoleService sysRoleService;



}