package org.simple.camunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class BPMNExample implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        int countUsers = (int) delegateExecution.getVariable("countUsers");
        int countVariable = (int) (Math.random() + 100);
        String variableStatus = "Simple 1";
        boolean isSendMessage = false;

        if ((countUsers - countVariable) < 1) {
            isSendMessage = true;
            variableStatus = "Send email";
        } else {
            variableStatus = "Dont send email";
        }

        delegateExecution.setVariable("variable", countVariable);
        delegateExecution.setVariable("variableStatus", variableStatus);
        delegateExecution.setVariable("isSendMessage", isSendMessage);
    }
}
