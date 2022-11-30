package world.deslauriers.controller.auth;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import reactor.core.publisher.Mono;
import world.deslauriers.client.AuthFetcher;
import world.deslauriers.model.auth.Profile;

import java.security.Principal;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/auth/profiles")
public class ProfilesController {

    private final AuthFetcher authFetcher;

    public ProfilesController(AuthFetcher authFetcher) {
        this.authFetcher = authFetcher;
    }

    @Get("/user")
    Mono<Profile> getUserProfile(){

        return authFetcher.getUserProfile();
    }
}
