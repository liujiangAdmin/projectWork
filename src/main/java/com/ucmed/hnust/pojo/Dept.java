package com.ucmed.hnust.pojo;

import java.io.Serializable;

/**
 * Created by ZY-LJ-1446 on 2018/4/19.
 */
public class Dept implements Serializable{
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getParentDeptId() {
        return parentDeptId;
    }

    public void setParentDeptId(Integer parentDeptId) {
        this.parentDeptId = parentDeptId;
    }

    public Integer getSortBy() {
        return sortBy;
    }

    public void setSortBy(Integer sortBy) {
        this.sortBy = sortBy;
    }

    private String deptName;
    private Integer deptId;
    private Integer parentDeptId;
    private Integer sortBy;
}
