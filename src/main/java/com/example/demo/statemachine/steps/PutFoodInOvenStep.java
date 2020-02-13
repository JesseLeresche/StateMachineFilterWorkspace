package com.example.demo.statemachine.steps;

import com.example.demo.statemachine.Context;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PutFoodInOvenStep extends AbstractStep {

    public PutFoodInOvenStep(String stepName) {
        super(stepName);
    }

    @Override
    protected Boolean executeStep(Context context) {
        return false;
    }
}
