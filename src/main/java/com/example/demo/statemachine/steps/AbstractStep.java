package com.example.demo.statemachine.steps;

import com.example.demo.statemachine.Context;
import com.example.demo.statemachine.constants.Status;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
@Slf4j
public abstract class AbstractStep {

    private AbstractStep onSuccessStep;
    private AbstractStep onFailureStep;
    private AbstractStep previousStep;
    private Status status;
    private String stepName;

    public Boolean execute(Context context){
        status = Status.IN_PROGRESS;
        logPreviousStep();
        Boolean stepResult = executeStep(context);
        evaluateResponse(stepResult);
        return stepResult;
    }

    protected abstract Boolean executeStep(Context context);

    public AbstractStep(String stepName) {
        this.stepName = stepName;
        status = Status.PENDING;
    }

    private void evaluateResponse(Boolean response){
        if (response) {
            status = Status.SUCCESS;
        } else {
            status = Status.FAIL;
        }
        log.info("Step {} completed with status {}", stepName, status);
    }

    private void logPreviousStep() {
        if (previousStep != null) {
            log.info("Executing step {} coming from step {}", stepName, previousStep.getStepName());
        } else {
            log.info("Starting new chain with step {}", stepName);
        }
    }

    public AbstractStep setOnSuccessStep(AbstractStep onSuccessStep) {
        this.onSuccessStep = onSuccessStep;
        return this;
    }

    public AbstractStep setOnFailureStep(AbstractStep onFailureStep) {
        this.onFailureStep = onFailureStep;
        return this;
    }
}
