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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.client.AuthFetcher;
import world.deslauriers.model.auth.Profile;

import javax.validation.Valid;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/auth/profiles")
public class ProfilesController {

    private static final Logger log = LoggerFactory.getLogger(ProfilesController.class);

    private final AuthFetcher authFetcher;

    public ProfilesController(AuthFetcher authFetcher) {
        this.authFetcher = authFetcher;
    }

    // User
    @Get("/user")
    Mono<Profile> getUserProfile(){
        return authFetcher.getUserProfile();
    }

    @Put("/user")
    Mono<HttpResponse> updateUserProfile(Profile profile){
        return authFetcher.updateUserProfile(profile);
    }

    // admin
    @Secured({"PROFILE_ADMIN"})
    @Get
    Flux<Profile> getAllProfiles(){
        return authFetcher.getAllUsers();
    }

    @Secured({"PROFILE_ADMIN", "PROFILE_READ"})
    @Get("/{uuid}")
    Mono<Profile> getByUuid(String uuid){
        return authFetcher.getProfileByUuid(uuid);
    }

    @Secured({"PROFILE_ADMIN"})
    @Put("/edit")
    Mono<HttpResponse> updateUser(@Body @Valid Profile updateCmd){
        return authFetcher.updateUser(updateCmd);
    }
}
