package world.deslauriers.client;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.http.client.annotation.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.model.auth.*;

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
    @Get("/profiles")
    Flux<Profile> getAllUsers();

    @Override
    @Get("/profiles/{uuid}")
    Mono<Profile> getProfileByUuid(String uuid);

    @Override
    @Put("/profiles/edit")
    Mono<HttpResponse> updateUser(@Body Profile updateCmd);

    // roles
    @Override
    @Get("/roles")
    Flux<Role> getAllRoles();

    @Override
    @Get("/roles/{id}")
    Mono<Role> getRoleById(Long id);

    @Override
    @Put("/roles")
    Mono<HttpResponse> updateRole(@Body Role role);

    @Override
    @Post("/roles")
    Mono<HttpResponse> saveRole(@Body Role role);

    // addresses
    @Override
    @Delete("/addresses/{id}")
    Mono<HttpResponse> deleteAddress(Long id);

    @Override
    @Delete("/addresses/delete/{id}")
    Mono<HttpResponse> deleteUserAddressById(Long id);

    // backup
    @Override
    @Get("/backup")
    Flux<User> backupAllUsers();
}
