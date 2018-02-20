package com.whirlpool.whirlpoolBackend.services;

import com.whirlpool.whirlpoolBackend.dao.ProjectRepository;
import com.whirlpool.whirlpoolBackend.dao.StepRepository;
import com.whirlpool.whirlpoolBackend.model.Project;
import com.whirlpool.whirlpoolBackend.model.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StepServiceImpl implements StepService{


    @Autowired
    private StepRepository stepRepository;

    @Override
    public List<Step> findAllStepOrder() {
        return stepRepository.findAllByOrderByOrderPositionAsc();
    }

    @Override
    public void saveOrUpdate(Step step) {
        stepRepository.save(step);
    }

    @Override
    public List<Step> findAllStepOrderByProject(Project project) {
        return stepRepository.findAllByProjectLikeOrderByOrderPositionAsc(project);
    }
}
