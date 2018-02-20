package com.whirlpool.whirlpoolBackend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects")
@Access(AccessType.FIELD)
public class Project extends ParentEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(
            mappedBy = "project",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch=FetchType.LAZY
    )
    @JsonManagedReference
    private List<Step> steps = new ArrayList<>();

    @Column(name = "description")
    private String description;

    public String getName() {
        return name;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
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
