package com.example.demo.statemachine;

import com.example.demo.statemachine.constants.Status;
import com.example.demo.statemachine.steps.AbstractStep;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Chain {

    private Status status;
    private AbstractStep currentStep;
    private Context chainContext;

    public Chain(Context chainContext) {
        this.chainContext = chainContext;
        status = Status.PENDING;
    }

    public Chain(AbstractStep currentStep, Context chainContext) {
        this.currentStep = currentStep;
        this.chainContext = chainContext;
    }

    public Chain() {
        status = Status.PENDING;
    }

    public void executeChain() {
        Boolean stepSuccess = currentStep.execute(chainContext);

        AbstractStep nextStep = getNextStep(stepSuccess);

        if (nextStep != null) {
            executeNextStep(nextStep);
        } else {
            finishChain();
        }
    }

    private void finishChain() {
        //TODO: Later this will do more complex processing regarding statuses for chains
        status = Status.SUCCESS;
        log.info("Chain Execution Complete with status {}", status);
    }

    private void executeNextStep(AbstractStep nextStep) {
        nextStep.setPreviousStep(currentStep);
        currentStep = nextStep;
        executeChain();
    }

    private AbstractStep getNextStep(Boolean stepSuccess) {
        AbstractStep nextStep;
        if (stepSuccess) {
            nextStep = currentStep.getOnSuccessStep();
        } else {
            nextStep = currentStep.getOnFailureStep();
        }
        return nextStep;
    }

}
