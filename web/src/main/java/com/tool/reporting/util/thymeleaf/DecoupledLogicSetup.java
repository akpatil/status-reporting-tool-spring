package com.tool.reporting.util.thymeleaf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class DecoupledLogicSetup {
    private final SpringResourceTemplateResolver templateResolver;

    public DecoupledLogicSetup(SpringResourceTemplateResolver templateResolver) {
        this.templateResolver = templateResolver;
    }

    @PostConstruct
    public void init() {
        log.info("DecoupledLogicSetup: init(): method called");
        templateResolver.setUseDecoupledLogic(true);
        log.info("DecoupledLogicSetup: init(): useDecoupledLogic set to true");
    }
}
