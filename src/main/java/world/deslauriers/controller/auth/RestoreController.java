package world.deslauriers.controller.auth;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;
import world.deslauriers.client.AuthFetcher;
import world.deslauriers.model.auth.BackupRole;
import world.deslauriers.model.auth.BackupUser;
import world.deslauriers.model.auth.BackupUserrole;

@Secured({"COLD_STORAGE"})
@Controller("/auth/restore")
public class RestoreController {

    private static final Logger log = LoggerFactory.getLogger(RestoreController.class);

    private final AuthFetcher authFetcher;

    public RestoreController(AuthFetcher authFetcher) {
        this.authFetcher = authFetcher;
    }

    @Post("/user")
    Mono<HttpResponse<?>> restoreUser(@Body BackupUser user){
        return authFetcher.restoreUser(user);
    }

    @Post("/role")
    Mono<HttpResponse<?>> retstoreRole(@Body BackupRole role){
        return authFetcher.restoreRole(role);
    }

    @Post("/user_role")
    Mono<HttpResponse<?>> restoreUserrole(@Body BackupUserrole userrole){
        return authFetcher.restoreUserrole(userrole);
    }
}
