package com.zy.system.zangyuesystem.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import springfox.documentation.annotations.ApiIgnore;

/**
 * (SysRoleMenu)实体类
 *
 * @author makejava
 * @since 2020-07-29 14:45:38
 */
@ApiModel("角色菜单")
@ApiIgnore
@Data
public class SysRoleMenu implements Serializable {
    private static final long serialVersionUID = 976326568321960204L;
    @ApiModelProperty("角色id")
    private Integer rid;
    @ApiModelProperty("菜单id")
    private Integer mid;

    public SysRoleMenu(Integer rid, Integer mid) {
        this.rid = rid;
        this.mid = mid;
    }
}