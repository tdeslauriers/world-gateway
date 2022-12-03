package world.deslauriers.client;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import world.deslauriers.model.auth.LoginRequest;
import world.deslauriers.model.auth.LoginResponse;
import reactor.core.publisher.Mono;
import world.deslauriers.model.auth.Profile;

import java.security.Principal;

public interface AuthFetcher {

    // login
    Mono<LoginResponse> login(LoginRequest loginRequest);

    // registration

    // profiles
    Mono<Profile> getUserProfile();

    Mono<HttpResponse> updateUserProfile(@Body Profile profile);
}
