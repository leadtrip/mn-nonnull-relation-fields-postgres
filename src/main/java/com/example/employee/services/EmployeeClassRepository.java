package com.example.employee.services;

import com.example.employee.models.EmployeeClassEntity;
import io.micronaut.data.annotation.Join;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.r2dbc.annotation.R2dbcRepository;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;

import java.util.UUID;


@Join(value = "roles", type = Join.Type.LEFT_FETCH)
@R2dbcRepository(dialect = Dialect.POSTGRES)
public interface EmployeeRepository extends ReactorCrudRepository<EmployeeClassEntity, UUID> {
}