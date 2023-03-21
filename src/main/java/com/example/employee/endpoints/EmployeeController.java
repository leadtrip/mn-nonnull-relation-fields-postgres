package com.example.employee.endpoints;

import com.example.employee.models.EmployeeDto;
import com.example.employee.models.EmployeeEntity;
import com.example.employee.services.EmployeeService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.micronaut.validation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;


@Controller("/api/employees")
@ExecuteOn(TaskExecutors.IO)
@Validated
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Get
    public Flux<EmployeeEntity> listEmployees() {
        return employeeService.list();
    }

    @Post
    public Mono<MutableHttpResponse<EmployeeEntity>> create(@Body EmployeeEntity employeeDto) {
        return Mono.from( employeeService.create(employeeDto) )
            .map( crDto -> HttpResponse.created( crDto )
            .headers(headers -> headers.location(location(crDto.getId()))));
    }

    private URI location(Long id) {
        return URI.create("/api/employees/" + id);
    }
}
