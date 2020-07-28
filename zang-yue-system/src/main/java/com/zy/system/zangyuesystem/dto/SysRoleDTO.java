package com.zy.system.zangyuesystem.dto;

import lombok.Data;

import java.util.List;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/7/28 16:56
 */
@Data
public class SysRoleDTO {

    private Integer id;

    private String roleName;

    private String roleIco;

    private String role;

    private List<SysMenuDTO> menus;

}
