package com.zy.system.zangyuesystem.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * (SysRole)实体类
 *
 * @author makejava
 * @since 2020-07-28 16:59:01
 */
@ApiModel("角色实体")
public class SysRole implements Serializable {
    private static final long serialVersionUID = 715501864657168451L;

    @ApiModelProperty("主键")
    private Integer id;
    @ApiModelProperty("角色名字")
    private String roleName;
    @ApiModelProperty("角色图标")
    private String roleIco;
    @ApiModelProperty("角色")
    private String role;
    @ApiModelProperty("是否删除")
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