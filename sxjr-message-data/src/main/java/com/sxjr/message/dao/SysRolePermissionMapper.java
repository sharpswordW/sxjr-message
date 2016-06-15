package com.sxjr.message.dao;

import com.sxjr.message.model.SysRolePermission;

public interface SysRolePermissionMapper {
    int deleteByPrimaryKey(Integer roleid);

    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);

    SysRolePermission selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(SysRolePermission record);

    int updateByPrimaryKey(SysRolePermission record);
}