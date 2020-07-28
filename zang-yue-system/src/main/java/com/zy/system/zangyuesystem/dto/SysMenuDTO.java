package com.zy.system.zangyuesystem.dto;

import lombok.Data;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/7/28 16:56
 */
@Data
public class SysMenuDTO {

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


}
