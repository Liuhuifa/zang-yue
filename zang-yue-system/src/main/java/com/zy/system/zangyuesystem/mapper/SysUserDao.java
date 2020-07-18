package com.zy.system.zangyuesystem.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zy.system.zangyuesystem.dto.SysUserDetails;
import com.zy.system.zangyuesystem.entity.SysUser;

import java.util.Map;


/**
 * @author lhf
 */
public interface SysUserDao extends BaseMapper<SysUser> {
    /**
     * 登录，用过用户名或者手机号查询用户信息
     *
     * @param params key 有两个，username,phone
     * @return SysUserDetails.class
     */
    SysUserDetails login(Map<String, String> params);
}