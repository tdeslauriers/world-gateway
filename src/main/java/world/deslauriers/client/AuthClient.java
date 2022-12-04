package world.deslauriers.client;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import reactor.core.publisher.Flux;
import world.deslauriers.model.auth.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Client(id = "auth")
public interface AuthClient extends AuthFetcher{

    // login
    @Override
    @Post("/login")
    Mono<LoginResponse> login(@Body LoginRequest loginRequest);

    // registration
    @Override
    @Post("/register")
    Mono<HttpResponse> register(@Body RegisterCmd registerCmd);

    @Override
    @Post("/register/user-available")
    Mono<HttpResponse> userExists(@Body String username);

    @Override
    @Post("/register/valid-password")
    Mono<HttpResponse> checkPasswordValid(@Body String password);

    @Override
    @Post("/register/passwords-match")
    Mono<HttpResponse> checkPasswordsMatch(@Body PasswordsMatchCmd cmd);

    // profiles
    @Override
    @Get("/profiles/user")
    Mono<Profile> getUserProfile();

    @Override
    @Put("/profiles/user")
    Mono<HttpResponse> updateUserProfile(@Body Profile profile);

    @Override
    @Get("/profiles/all")
    Flux<Profile> getAllUsers();

    @Override
    @Get("/profiles/{id}")
    Mono<Profile> getProfileById(Long id);

    @Override
    @Put("/profiles/edit")
    Mono<HttpResponse> updateUser(@Body Profile updateCmd);

    // backup
    @Override
    @Get("/backup")
    Flux<Profile> backupAllUsers();
}
