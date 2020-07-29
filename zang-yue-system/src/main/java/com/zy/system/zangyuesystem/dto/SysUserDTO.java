package com.zy.system.zangyuesystem.dto;

import com.zy.common.zangyuecommon.annotations.Ignore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/7/29 11:32
 */
@Data
@ApiModel("添加用户的实体")
public class SysUserDTO {

    /**
     * 主键
     */
    @ApiModelProperty("主键")
    private Long id;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String username;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String phone;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;

    /**
     * 真实名字
     */
    @ApiModelProperty("真实名字")
    private String realName;

    /**
     * 头像地址
     */
    @ApiModelProperty("头像地址")
    private String headImg;

    /**
     * 用户的所有角色
     */
    @ApiModelProperty("用户的所有角色的id")
    @Ignore
    private List<Integer> roles;
}
