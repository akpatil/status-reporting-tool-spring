package com.tool.reporting.service;

import com.tool.reporting.entity.Status;
import com.tool.reporting.repository.StatusRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StatusService {
    private StatusRepository statusRepository;

    @Autowired
    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public List<Status> getAllStatus() {
        log.info("StatusService: getAllStatus(): method called");
        return statusRepository.findAll();
    }
}
