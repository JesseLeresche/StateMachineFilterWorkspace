package com.example.demo.statemachine.steps;

import com.example.demo.statemachine.Context;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TurnOvenOnStep extends AbstractStep {

    public TurnOvenOnStep(String stepName) {
        super(stepName);
    }

    @Override
    protected Boolean executeStep(Context context) {
        log.info("Logging some arbitrary value from the context {}", context.getParameter("randomKey"));
        return (Boolean) context.getParameter("POE_Success");
    }
}
