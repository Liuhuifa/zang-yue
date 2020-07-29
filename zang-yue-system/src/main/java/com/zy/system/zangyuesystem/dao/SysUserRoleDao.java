package com.zy.system.zangyuesystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zy.system.zangyuesystem.entity.SysUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (SysUserRole)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-29 14:46:00
 */
public interface SysUserRoleDao extends BaseMapper<SysUserRole> {
    /**
     * 添加
     *
     * @param list 要添加的实体集合
     * @return 受影响行数
     */
    int insert(@Param("list") List<SysUserRole> list);
}