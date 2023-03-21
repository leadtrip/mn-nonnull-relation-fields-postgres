package com.example.employee.models;

import com.example.role.models.RoleRecordEntity;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.AutoPopulated;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;
import io.micronaut.data.jdbc.annotation.JoinColumn;
import io.micronaut.data.jdbc.annotation.JoinTable;

import java.util.Set;
import java.util.UUID;

@MappedEntity("employee")
public class EmployeeEntity {
    @Id
    @AutoPopulated
    private UUID id;

    private String name;

    public EmployeeEntity(String name, @Nullable Set<RoleRecordEntity> roles) {
        this.name = name;
        this.roles = roles;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Nullable
    public Set<RoleRecordEntity> getRoles() {
        return roles;
    }

    public void setRoles(@Nullable Set<RoleRecordEntity> roles) {
        this.roles = roles;
    }

    @JoinTable(
            name = "employee_roles",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @Relation(
            value = Relation.Kind.MANY_TO_MANY,
            cascade = Relation.Cascade.PERSIST
    )
    @Nullable
    private Set<RoleRecordEntity> roles;
}