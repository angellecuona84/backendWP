package com.whirlpool.whirlpoolBackend.model;

import javax.persistence.*;

@Entity
@Table(name = "projects")
@Access(AccessType.FIELD)
public class Project extends ParentEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
