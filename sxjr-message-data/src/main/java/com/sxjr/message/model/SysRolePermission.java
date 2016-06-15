package com.sxjr.message.model;

public class SysRolePermission {
    private Integer roleid;

    private String permissions;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions == null ? null : permissions.trim();
    }
}