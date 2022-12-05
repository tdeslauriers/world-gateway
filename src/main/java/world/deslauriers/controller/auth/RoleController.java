package world.deslauriers.controller.auth;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.client.AuthFetcher;
import world.deslauriers.model.auth.Role;

import javax.validation.Valid;

@Secured({"PROFILE_ADMIN"})
@Controller("/auth/roles")
public class RoleController {

    protected final AuthFetcher authFetcher;

    public RoleController(AuthFetcher authFetcher) {
        this.authFetcher = authFetcher;
    }

    @Get
    Flux<Role> getAllRoles(){
        return authFetcher.getAllRoles();
    }

    @Get("/{id}")
    Mono<Role> getRoleById(Long id){
        return authFetcher.getRoleById(id);
    }

    @Put
    Mono<HttpResponse> updateRole(@Body @Valid Role role){
        return authFetcher.updateRole(role);
    }

    @Post
    Mono<HttpResponse> save(@Body @Valid Role role){
        return authFetcher.saveRole(role);
    }
}
