package com.zy.system.zangyuesystem.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * sys_user
 * @author lhf
 */
@Data
public class SysUser implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实名字
     */
    private String realName;

    /**
     * 头像地址
     */
    private String headImg;

    private static final long serialVersionUID = 1L;


}