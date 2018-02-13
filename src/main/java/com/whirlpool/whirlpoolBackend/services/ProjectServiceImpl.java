package com.whirlpool.whirlpoolBackend.services;

import com.whirlpool.whirlpoolBackend.dao.ProjectRepository;
import com.whirlpool.whirlpoolBackend.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void saveOrUpdate(Project project) {
        projectRepository.save(project);
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public void deleteProject(Project project) {
        projectRepository.delete(project.getId());
    }
}


