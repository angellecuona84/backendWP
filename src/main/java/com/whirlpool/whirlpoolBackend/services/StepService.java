package com.whirlpool.whirlpoolBackend.services;

import com.whirlpool.whirlpoolBackend.model.Step;

import java.util.List;

public interface StepService {
    List<Step> findAllStepOrder();

    void saveOrUpdate(Step step);
}
