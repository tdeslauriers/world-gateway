package world.deslauriers.controller.auth;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Put;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;
import world.deslauriers.client.AuthFetcher;
import world.deslauriers.model.auth.Profile;

import javax.validation.Valid;
import java.security.Principal;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/auth/profiles")
public class ProfilesController {

    private static final Logger log = LoggerFactory.getLogger(ProfilesController.class);

    private final AuthFetcher authFetcher;

    public ProfilesController(AuthFetcher authFetcher) {
        this.authFetcher = authFetcher;
    }

    @Get("/user")
    Mono<Profile> getUserProfile(){
        return authFetcher.getUserProfile();
    }

    @Put("/user")
    Mono<HttpResponse> updateUserProfile(@Body Profile profile){
        return authFetcher.updateUserProfile(profile);
    }
}
