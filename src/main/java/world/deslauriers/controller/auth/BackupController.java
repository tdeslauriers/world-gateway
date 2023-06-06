package world.deslauriers.controller.auth;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import reactor.core.publisher.Flux;
import world.deslauriers.client.AuthFetcher;
import world.deslauriers.model.auth.User;

@Secured({"COLD_STORAGE"})
@Controller("/auth/backup")
public class BackupController {

    protected final AuthFetcher authFetcher;

    public BackupController(AuthFetcher authFetcher) {
        this.authFetcher = authFetcher;
    }

    @Get
    Flux<User> backup(){
        return authFetcher.backupAllUsers();
    }
}
