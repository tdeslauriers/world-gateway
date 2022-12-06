package world.deslauriers.controller.auth;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Status;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import reactor.core.publisher.Mono;
import world.deslauriers.client.AuthFetcher;

import java.security.Principal;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/auth/addresses")
public class AddressController {

    protected final AuthFetcher authFetcher;

    public AddressController(AuthFetcher authFetcher) {
        this.authFetcher = authFetcher;
    }

    @Delete("/{id}")
    Mono<HttpResponse> deleteAddress(Long id){
        return authFetcher.deleteAddress(id);
    }

    @Secured({"PROFILE_ADMIN"})
    @Delete("/delete/{id}")
    Mono<HttpResponse> deleteUserAddress(Long id){
        return authFetcher.deleteUserAddressById(id);
    }
}
