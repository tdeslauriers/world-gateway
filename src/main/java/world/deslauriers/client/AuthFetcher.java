package world.deslauriers.client;

import world.deslauriers.model.auth.LoginRequest;
import world.deslauriers.model.auth.LoginResponse;
import reactor.core.publisher.Mono;

public interface AuthFetcher {

    Mono<LoginResponse> login(LoginRequest loginRequest);
}
