package world.deslauriers.controller.allowance;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import reactor.core.publisher.Mono;
import world.deslauriers.client.AllowanceFetcher;
import world.deslauriers.model.allowance.Allowance;

import javax.validation.Valid;

@Secured({"ALLOWANCE_ADMIN", "ALLOWANCE_USER"})
@Controller("/allowance/allowances")
public class AllowanceController {

    protected final AllowanceFetcher allowanceFetcher;

    public AllowanceController(AllowanceFetcher allowanceFetcher) {
        this.allowanceFetcher = allowanceFetcher;
    }

//    @Get("/{id}")
//    Mono<Allowance> getTasksByAllowanceId(Long id){
//        return allowanceFetcher.getTasksByALlowanceId(id);
//    }

    @Post
    Mono<HttpResponse<Allowance>> save(@Body @Valid Allowance cmd){
        return allowanceFetcher.saveAllownace(cmd);
    }
}
