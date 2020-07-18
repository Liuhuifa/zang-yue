package com.zy.zangyueweb.controller;

import com.zy.system.zangyuesystem.entity.SysUser;
import com.zy.system.zangyuesystem.service.inter.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/7/18$ 10:53$
 */
@RestController
@RequestMapping("sys-user")
@Api(tags = "后台用户接口")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;


    @PostMapping("add")
    @ApiOperation(value = "添加用户", httpMethod = "POST")
    public int insert(@RequestBody SysUser sysUser) {
        return sysUserService.insert(sysUser);
    }

}
