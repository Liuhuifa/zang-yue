package com.zy.system.zangyuesystem.service.inter;

import com.zy.system.zangyuesystem.entity.SysUser;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/7/18$ 8:38$
 */
public interface SysUserService {

    /**
     * 添加用户
     *
     * @param sysUser 用户实体
     * @return int 受影响行数
     */
    int insert(SysUser sysUser);

    /**
     * 查询用户名是否存在
     *
     * @param username 用户名
     * @return Boolean true 存在，false 不存在
     */
    boolean usernameExist(String username);

    /**
     * 查询手机号是否存在
     *
     * @param phone 后几号
     * @return Boolean true 存在，false 不存在
     */
    boolean phoneExist(String phone);
}
