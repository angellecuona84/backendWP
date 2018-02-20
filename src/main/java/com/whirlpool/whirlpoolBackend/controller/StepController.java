package com.whirlpool.whirlpoolBackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.whirlpool.whirlpoolBackend.model.Project;
import com.whirlpool.whirlpoolBackend.model.Step;
import com.whirlpool.whirlpoolBackend.services.StepService;
import com.whirlpool.whirlpoolBackend.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class StepController{

    @Autowired
    private StepService stepService;

    private ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(value = "getOrderStep", method = RequestMethod.GET)
    public List<Step> getOrderStepForProject(){
        List<Step> a = stepService.findAllStepOrder();
        return stepService.findAllStepOrder();
    }

    @RequestMapping(value = "getOrderStepByProject", method = RequestMethod.POST)
    public List<Step>  getOrderStepForProject(@RequestBody String projectJson) throws IOException {

        Project project = mapper.readValue(projectJson, Project.class);

        List<Step> result = stepService.findAllStepOrderByProject(project);

        return result;
    }

    @RequestMapping(value = "saveOrUpdateStep", method = RequestMethod.POST)
    public RestResponse saveOrUpdate(@RequestBody String stepJson) throws IOException {

        Step step = mapper.readValue(stepJson, Step.class);

        if (!validateStep(step)){
            return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Step not validate");
        }
        stepService.saveOrUpdate(step);

        return new RestResponse(HttpStatus.OK.value(), "Success Operation");
    }

    private boolean validateStep(Step step) {

        if (step.getName() == null){
            return false;
        }
        if (step.getOrderPosition() == null){
            return false;
        }
        return true;
    }
}
