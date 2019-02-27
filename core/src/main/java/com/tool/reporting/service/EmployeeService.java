package com.tool.reporting.service;

import com.tool.reporting.entity.Employee;
import com.tool.reporting.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        log.info("EmployeeService: getAllEmployees(): method called");
        return employeeRepository.findAll();
    }
}
