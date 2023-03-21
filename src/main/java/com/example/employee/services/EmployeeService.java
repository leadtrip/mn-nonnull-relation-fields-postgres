package com.example.employee.services;

import com.example.employee.models.EmployeeDto;
import com.example.employee.models.EmployeeEntity;
import jakarta.inject.Singleton;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Singleton
public class EmployeeService {

    private final EmployeeTransformer employeeTransformer;
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeTransformer employeeTransformer, EmployeeRepository employeeRepository) {
        this.employeeTransformer = employeeTransformer;
        this.employeeRepository = employeeRepository;
    }

    public Flux<EmployeeEntity> list() {
        return employeeRepository.findAll();
            //.map(employeeTransformer::from);
    }

    public Mono<EmployeeEntity> create(EmployeeEntity employee) {
        return employeeRepository.save((employee));
            //.map(employeeTransformer::from);
    }

}
