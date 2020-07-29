package com.zy.system.zangyuesystem.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/7/28 16:56
 */
@Data
@Api("角色实体")
public class SysRoleDTO {

    @ApiModelProperty("主键")
    private Integer id;
    @ApiModelProperty("角色名")
    private String roleName;
    @ApiModelProperty("角色图标")
    private String roleIco;
    @ApiModelProperty("角色")
    private String role;
    @ApiModelProperty("")
    private List<SysMenuDTO> menus;

}
