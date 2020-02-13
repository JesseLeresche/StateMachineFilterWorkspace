package com.example.demo;

import com.example.demo.statemachine.Chain;
import com.example.demo.statemachine.steps.ChainBuilder;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StateDemoRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
        Chain chain = ChainBuilder.buildDemoChain();
        chain.executeChain();
    }

}
