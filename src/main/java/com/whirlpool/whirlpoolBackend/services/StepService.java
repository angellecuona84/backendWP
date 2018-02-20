package com.whirlpool.whirlpoolBackend.services;

import com.whirlpool.whirlpoolBackend.model.Project;
import com.whirlpool.whirlpoolBackend.model.Step;

import java.util.List;

public interface StepService {
    List<Step> findAllStepOrder();

    void saveOrUpdate(Step step);

    List<Step> findAllStepOrderByProject(Project project);
}
