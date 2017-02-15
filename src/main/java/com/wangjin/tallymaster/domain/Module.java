package com.wangjin.tallymaster.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created with Intellij IDEA by 王金 on 2017/2/15 上午11:11.
 */
@Entity
@Table(name = "t_module")
public class Module {

    @Id
    @GeneratedValue(generator = "id-generator")
    @GenericGenerator(name = "id-generator",strategy = "uuid2")
    @Column(length = 36)
    private String id;

    @Column(length = 50)
    private String moduleName;

    @Column
    private Integer moduleOrder;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
