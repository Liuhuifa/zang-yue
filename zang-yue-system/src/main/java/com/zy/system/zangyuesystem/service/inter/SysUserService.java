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
}
