package com.wangjin.tallymaster.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by wangjin on 2017/2/15.
 */
@Entity
@Table(name = "t_role")
public class Role extends BaseModel{

    @Column(length = 50)
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
