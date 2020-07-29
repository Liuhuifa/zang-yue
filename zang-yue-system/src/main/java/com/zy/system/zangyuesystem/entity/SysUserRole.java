package com.zy.system.zangyuesystem.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import springfox.documentation.annotations.ApiIgnore;

/**
 * (SysUserRole)实体类
 *
 * @author makejava
 * @since 2020-07-29 14:46:00
 */
@ApiModel("用户角色实体类")
@ApiIgnore
@Data
public class SysUserRole implements Serializable {
    private static final long serialVersionUID = 384970179218390565L;
    @ApiModelProperty("用户id")
    private Long uid;
    @ApiModelProperty("角色id")
    private Integer rid;

    public SysUserRole(Long uid, Integer rid) {
        this.uid = uid;
        this.rid = rid;
    }
}