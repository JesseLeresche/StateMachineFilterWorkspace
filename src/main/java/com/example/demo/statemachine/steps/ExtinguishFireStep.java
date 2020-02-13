package com.example.demo.statemachine.steps;

import com.example.demo.statemachine.Context;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExtinguishFireStep extends AbstractStep {

    public ExtinguishFireStep(String stepName) {
        super(stepName);
    }

    @Override
    protected Boolean executeStep(Context context) {
        context.putParameter("POE_Success", true);
        return true;
    }
}
