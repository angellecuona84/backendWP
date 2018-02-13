package com.whirlpool.whirlpoolBackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.whirlpool.whirlpoolBackend.model.Project;
import com.whirlpool.whirlpoolBackend.services.ProjectService;
import com.whirlpool.whirlpoolBackend.util.QueryResult;
import com.whirlpool.whirlpoolBackend.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    private ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(value = "saveOrUpdate", method = RequestMethod.POST)
    public RestResponse saveOrUpdate(@RequestBody String projectJson) throws IOException {

        Project project = mapper.readValue(projectJson, Project.class);

        if (!validateProject(project)){
            return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Project not validate");
        }
        projectService.saveOrUpdate(project);

        return new RestResponse(HttpStatus.OK.value(), "Success Operation");
    }

    private boolean validateProject(Project project) {

        if (project.getName() == null){
            return false;
        }
        return true;
    }

    @RequestMapping(value = "getProjects", method = RequestMethod.GET)
    public List<Project> getProjects(){
        return projectService.findAll();
    }

    @RequestMapping(value = "deleteProject", method = RequestMethod.POST)
    public RestResponse deleteProject(@RequestBody String projectJson) throws IOException {
        Project project = mapper.readValue(projectJson, Project.class);
        if (project.getId() == null){
            return new RestResponse(HttpStatus.BAD_REQUEST.value(), "Error Occurred");
        }

        projectService.deleteProject(project);
        return new RestResponse(HttpStatus.OK.value(), "Success Operation");
    }
}
