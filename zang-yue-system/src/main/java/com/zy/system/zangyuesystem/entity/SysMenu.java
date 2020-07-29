package com.zy.system.zangyuesystem.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * (SysMenu)实体类
 *
 * @author makejava
 * @since 2020-07-28 16:51:18
 */
@ApiModel("菜单实体")
@Data
public class SysMenu implements Serializable {
    private static final long serialVersionUID = 310700619972546575L;

    @ApiModelProperty("主键")
    private Integer id;
    /**
    * 权限名字
    */
    @ApiModelProperty("权限名字")
    private String perName;
    /**
    * 菜单名字
    */
    @ApiModelProperty("菜单名字")
    private String menuName;
    @ApiModelProperty("菜单图标")
    private String menuIco;
    /**
    * 0 菜单 1按钮
    */
    @ApiModelProperty("0 菜单 1按钮")
    private Integer menuType;
    /**
    * 父类id 0为一级菜单
    */
    @ApiModelProperty("父类id 0为一级菜单")
    private Integer parentId;



}