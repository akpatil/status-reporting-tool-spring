package com.tool.reporting.service;

import com.tool.reporting.entity.Strategy;
import com.tool.reporting.repository.StrategyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StrategyService {
    private StrategyRepository strategyRepository;

    @Autowired
    public StrategyService(StrategyRepository strategyRepository) {
        this.strategyRepository = strategyRepository;
    }

    public List<Strategy> getAllStrategies() {
        log.info("StrategyService: getAllStrategies(): method called");
        return strategyRepository.findAll();
    }
}
