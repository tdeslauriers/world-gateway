package world.deslauriers.controller.auth;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import reactor.core.publisher.Mono;
import world.deslauriers.client.AuthFetcher;
import world.deslauriers.model.auth.PasswordsMatchCmd;
import world.deslauriers.model.auth.RegisterCmd;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/auth/register")
public class RegistrationController {

    protected final AuthFetcher authFetcher;

    public RegistrationController(AuthFetcher authFetcher) {
        this.authFetcher = authFetcher;
    }

    @Post
    Mono<HttpResponse> register(@Body @Valid RegisterCmd registerCmd){
        return authFetcher.register(registerCmd);
    }

    @Post("/user-available")
    Mono<HttpResponse> checkExistingUser(@Body @NonNull @NotBlank @Email @Size(max = 254) String username){
        return authFetcher.userExists(username);
    }

    @Post("/valid-password")
    Mono<HttpResponse> checkPasswordValid (@Body @NonNull @NotBlank String password){

        // error will be thrown by @Valid annotations on dto
        return authFetcher.checkPasswordValid(password);
    }

    @Post("/passwords-match")
    Mono<HttpResponse> checkPasswordsMatch(@Body @Valid PasswordsMatchCmd cmd){
        return authFetcher.checkPasswordsMatch(cmd);
    }
}
