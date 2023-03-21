package com.example.role.models;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.AutoPopulated;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
//import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;



//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@MappedEntity("role")
public record RoleEntity (
    @Id
    @AutoPopulated
    UUID id,

    @NonNull
    String name
){
    public RoleEntity( UUID id ){
        this(id, null);
    }
}
