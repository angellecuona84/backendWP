package com.whirlpool.whirlpoolBackend.services;

import com.whirlpool.whirlpoolBackend.model.Project;
import com.whirlpool.whirlpoolBackend.util.QueryResult;

import java.util.List;

public interface ProjectService {

    void saveOrUpdate(Project project);

    List<Project> findAll();

    void deleteProject(Project project);
}
