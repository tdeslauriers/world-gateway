package world.deslauriers.controller.auth;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import reactor.core.publisher.Mono;
import world.deslauriers.client.AuthFetcher;
import world.deslauriers.model.auth.LoginRequest;
import world.deslauriers.model.auth.LoginResponse;
import world.deslauriers.model.auth.RefreshTokenCmd;

import javax.validation.Valid;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/auth")
public class AuthController {

    private final AuthFetcher authFetcher;

    public AuthController(AuthFetcher authFetcher) {
        this.authFetcher = authFetcher;
    }

    @Post("/login")
    Mono<MutableHttpResponse<?>> login(LoginRequest loginRequest){
        return authFetcher.login(loginRequest);
    }

    @Post("/refresh")
    Mono<MutableHttpResponse<?>> refreshToken(@Body @Valid RefreshTokenCmd cmd){
        return authFetcher.refresh(cmd);
    }
}
