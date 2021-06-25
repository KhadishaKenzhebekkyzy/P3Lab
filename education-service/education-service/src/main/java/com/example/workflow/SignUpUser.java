package com.example.workflow;

import com.example.workflow.models.User;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SignUpUser implements JavaDelegate {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        User user = restTemplate.getForObject("http://users-service/sign-up", User.class);
        delegateExecution.setVariable("registered", user);
    }
}
