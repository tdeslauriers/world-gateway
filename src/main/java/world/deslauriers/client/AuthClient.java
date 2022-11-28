package world.deslauriers.client;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import world.deslauriers.model.auth.LoginRequest;
import world.deslauriers.model.auth.LoginResponse;
import reactor.core.publisher.Mono;

@Client(id = "auth")
public interface AuthClient extends AuthFetcher{

    @Override
    @Post("/login")
    Mono<LoginResponse> login(@Body LoginRequest loginRequest);
}
