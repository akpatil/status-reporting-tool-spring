package com.tool.reporting.service;

import com.tool.reporting.repository.GroupsRepository;
import com.tool.reporting.repository.HealthRepository;
import com.tool.reporting.repository.StatusRepository;
import com.tool.reporting.repository.StrategyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CommonService {
    @Autowired
    private GroupsRepository groupRepository;
    @Autowired
    private HealthRepository healthRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private StrategyRepository strategyRepository;

}
