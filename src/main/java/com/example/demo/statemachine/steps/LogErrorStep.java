package com.example.demo.statemachine.steps;

import com.example.demo.statemachine.Context;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogErrorStep extends AbstractStep {

    public LogErrorStep(String stepName) {
        super(stepName);
    }

    @Override
    protected Boolean executeStep(Context context) {
        log.error("Error occured during processing. Logging this so that someobody sees it");
        return true;
    }

}
