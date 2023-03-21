package com.example.role.services;

import com.example.role.models.RoleDto;
import com.example.role.models.RoleEntity;
import jakarta.inject.Singleton;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Singleton
public class RoleService {

    private final RoleTransformer roleTransformer;
    private final RoleRepository roleRepository;

    public RoleService(RoleTransformer roleTransformer, RoleRepository roleRepository) {
        this.roleTransformer = roleTransformer;
        this.roleRepository = roleRepository;
    }


    public Flux<RoleEntity> findAll() {
        return roleRepository.findAll();
                //.map(roleTransformer::from);
    }

    public Mono<RoleEntity> create(RoleEntity role) {
        return roleRepository.save(role);
                //.map(roleTransformer::from);
    }

}
