package com.zy.zangyueweb.controller;

import com.zy.common.zangyuecommon.result.Result;
import com.zy.system.zangyuesystem.entity.SysUser;
import com.zy.system.zangyuesystem.service.inter.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

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
    @Resource
    private SysUserService sysUserService;
    @Resource
    private PasswordEncoder passwordEncoder;

    @PostMapping("add")
    @ApiOperation(value = "添加用户", httpMethod = "POST")
    public Result<Object> insert(@RequestBody SysUser sysUser) {
        sysUser.setPassword(passwordEncoder.encode(sysUser.getPassword()));
        return Result.success(sysUserService.insert(sysUser));
    }

    @GetMapping("has-username")
    @ApiOperation(value = "用户名是否存在", httpMethod = "GET")
    public Result<Boolean> hasUsername(@RequestBody String username) {
        return Result.success(sysUserService.usernameExist(username));
    }

    @GetMapping("has-phone")
    @ApiOperation(value = "用户名是否存在", httpMethod = "GET")
    public Result<Boolean> hasPhone(@RequestBody String phone) {
        return Result.success(sysUserService.phoneExist(phone));
    }
}
