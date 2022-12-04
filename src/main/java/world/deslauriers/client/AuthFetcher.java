package world.deslauriers.client;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.model.auth.*;

public interface AuthFetcher {

    // login
    Mono<LoginResponse> login(LoginRequest loginRequest);

    // registration
    Mono<HttpResponse> register(RegisterCmd registerCmd);
    Mono<HttpResponse> userExists(String username);
    Mono<HttpResponse> checkPasswordValid(String password);
    Mono<HttpResponse> checkPasswordsMatch(PasswordsMatchCmd cmd);

    // profiles
    Mono<Profile> getUserProfile();
    Mono<HttpResponse> updateUserProfile(@Body Profile profile);
    Flux<Profile> getAllUsers();
    Mono<Profile> getProfileById(Long id);
    Mono<HttpResponse> updateUser(Profile updateCmd);

    // backup
    Flux<Profile> backupAllUsers();
}
