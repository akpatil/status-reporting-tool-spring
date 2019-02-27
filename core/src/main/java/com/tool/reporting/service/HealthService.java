package com.tool.reporting.service;

import com.tool.reporting.entity.Health;
import com.tool.reporting.repository.HealthRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class HealthService {
    private HealthRepository healthRepository;

    @Autowired
    public HealthService(HealthRepository healthRepository) {
        this.healthRepository = healthRepository;
    }

    public List<Health> getAllHealths() {
        log.info("HealthService: getAllHealths(): method called");
        return healthRepository.findAll();
    }
}
