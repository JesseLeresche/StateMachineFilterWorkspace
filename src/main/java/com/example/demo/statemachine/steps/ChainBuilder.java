package com.example.demo.statemachine.steps;

import com.example.demo.statemachine.Chain;
import com.example.demo.statemachine.Context;

public class ChainBuilder {

    public static Chain buildDemoChain() {
        AbstractStep poeStep = new ExtinguishFireStep("ExtinguishFireStep");
        AbstractStep pooaStep = new PutFoodInOvenStep("PutFoodInOvenStep");
        AbstractStep logErrorStep = new LogErrorStep("LogErrorStep");
        AbstractStep authRepsStep = new TurnOvenOnStep("TurnOvenOnStep");

        poeStep.setOnSuccessStep(pooaStep).setOnFailureStep(logErrorStep);
        pooaStep.setOnFailureStep(logErrorStep);
        logErrorStep.setOnSuccessStep(authRepsStep);

        Context context = new Context();
        context.putParameter("randomKey", "someValue");

        return new Chain(poeStep, context);
    }

}
