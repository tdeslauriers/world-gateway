package world.deslauriers.controller.auth;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import reactor.core.publisher.Mono;
import world.deslauriers.client.AuthFetcher;
import world.deslauriers.model.auth.BackupUser;

@Secured({"COLD_STORAGE"})
@Controller("/auth/restore")
public class RestoreController {

    private final AuthFetcher authFetcher;

    public RestoreController(AuthFetcher authFetcher) {
        this.authFetcher = authFetcher;
    }

    @Post("/user")
    Mono<HttpResponse<?>> restoreUser(BackupUser user){
        return authFetcher.restoreUser(user);
    }
}
