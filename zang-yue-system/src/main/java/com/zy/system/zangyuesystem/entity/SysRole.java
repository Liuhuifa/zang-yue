package com.zy.system.zangyuesystem.entity;

import java.io.Serializable;

/**
 * (SysRole)实体类
 *
 * @author makejava
 * @since 2020-07-28 16:59:01
 */
public class SysRole implements Serializable {
    private static final long serialVersionUID = 715501864657168451L;
    
    private Integer id;
    
    private String roleName;
    
    private String roleIco;
    
    private String role;
    
    private Integer isDel;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleIco() {
        return roleIco;
    }

    public void setRoleIco(String roleIco) {
        this.roleIco = roleIco;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

}