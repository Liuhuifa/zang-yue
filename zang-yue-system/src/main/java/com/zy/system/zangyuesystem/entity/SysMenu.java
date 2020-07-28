package com.zy.system.zangyuesystem.entity;

import java.io.Serializable;

/**
 * (SysMenu)实体类
 *
 * @author makejava
 * @since 2020-07-28 16:51:18
 */
public class SysMenu implements Serializable {
    private static final long serialVersionUID = 310700619972546575L;
    
    private Integer id;
    /**
    * 权限名字
    */
    private String perName;
    /**
    * 菜单名字
    */
    private String menuName;
    
    private String menuIco;
    /**
    * 0 菜单 1按钮
    */
    private Integer menuType;
    /**
    * 父类id 0为一级菜单
    */
    private Integer parentId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPerName() {
        return perName;
    }

    public void setPerName(String perName) {
        this.perName = perName;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuIco() {
        return menuIco;
    }

    public void setMenuIco(String menuIco) {
        this.menuIco = menuIco;
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

}