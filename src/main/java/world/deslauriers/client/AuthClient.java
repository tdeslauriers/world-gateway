package world.deslauriers.client;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import world.deslauriers.model.auth.LoginRequest;
import world.deslauriers.model.auth.LoginResponse;
import reactor.core.publisher.Mono;
import world.deslauriers.model.auth.Profile;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Client(id = "auth")
public interface AuthClient extends AuthFetcher{

    // login
    @Override
    @Post("/login")
    Mono<LoginResponse> login(@Body LoginRequest loginRequest);

    // registration

    // profiles
    @Override
    @Get("/profiles/user")
    Mono<Profile> getUserProfile();

    @Override
    @Put("/profiles/user")
    Mono<HttpResponse> updateUserProfile(@Body Profile profile);
}
