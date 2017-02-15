package com.wangjin.tallymaster.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created with Intellij IDEA by 王金 on 2017/2/15 上午11:11.
 */
@Entity
@Table(name = "t_module")
public class Module extends BaseModel{

    @Column(length = 50)
    private String moduleName;

    @Column
    private Integer moduleOrder;

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Integer getModuleOrder() {
        return moduleOrder;
    }

    public void setModuleOrder(Integer moduleOrder) {
        this.moduleOrder = moduleOrder;
    }
}
