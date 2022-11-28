package world.deslauriers.controller;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import reactor.core.publisher.Mono;
import world.deslauriers.client.AuthFetcher;
import world.deslauriers.model.auth.LoginRequest;
import world.deslauriers.model.auth.LoginResponse;

import javax.validation.Valid;

@Controller("/api/v1/auth")
public class AuthController {

    private final AuthFetcher authFetcher;

    public AuthController(AuthFetcher authFetcher) {
        this.authFetcher = authFetcher;
    }

    @Secured(SecurityRule.IS_ANONYMOUS)
    @Post("/login")
    Mono<LoginResponse> login(@Body @Valid LoginRequest loginRequest){

        return authFetcher.login(loginRequest);
    }
}
