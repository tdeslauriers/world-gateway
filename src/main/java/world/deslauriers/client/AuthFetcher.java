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
    Mono<HttpResponse> resetPassword(ResetPasswordCmd cmd);
    Flux<Profile> getAllUsers();
    Mono<Profile> getProfileByUuid(String uuid);
    Mono<HttpResponse> updateUser(Profile updateCmd);

    // roles
    Flux<Role> getAllRoles();
    Mono<Role> getRoleById(Long id);
    Mono<HttpResponse> updateRole(Role role);
    Mono<HttpResponse> saveRole(Role role);
    
    // address 
    Mono<HttpResponse> deleteAddress(Long id);
    Mono<HttpResponse> deleteUserAddressById(Long id);
    
    // backup
    Flux<User> backupAllUsers();

}
