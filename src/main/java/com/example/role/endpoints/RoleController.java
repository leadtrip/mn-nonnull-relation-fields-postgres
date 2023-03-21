package com.example.role.endpoints;

import com.example.role.models.RoleDto;
import com.example.role.models.RoleEntity;
import com.example.role.services.RoleService;
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


@ExecuteOn(TaskExecutors.IO)
@Validated
@Controller("/api/roles")
public class RoleController {
    
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }


    @Get
    public Flux<RoleEntity> listRoles() {
        return roleService.findAll();
    }

    @Post
    public Mono<MutableHttpResponse<RoleEntity>> create(@Body RoleEntity roleDto) {
        return Mono.from( roleService.create(roleDto) )
                .map( rlDto -> HttpResponse.created(rlDto)
                        .headers(headers -> headers.location(location(rlDto.getId()))));
    }


    private URI location(Long id) {
        return URI.create("/api/roles/" + id);
    }
}
