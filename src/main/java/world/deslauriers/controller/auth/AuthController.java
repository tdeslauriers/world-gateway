package world.deslauriers.controller.auth;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import reactor.core.publisher.Mono;
import world.deslauriers.client.AuthFetcher;
import world.deslauriers.model.auth.LoginRequest;
import world.deslauriers.model.auth.LoginResponse;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/auth")
public class AuthController {

    private final AuthFetcher authFetcher;

    public AuthController(AuthFetcher authFetcher) {
        this.authFetcher = authFetcher;
    }


    @Post("/login")
    Mono<LoginResponse> login(LoginRequest loginRequest){
        return authFetcher.login(loginRequest);
    }
}
