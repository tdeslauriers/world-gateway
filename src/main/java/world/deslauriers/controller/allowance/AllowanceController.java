package world.deslauriers.controller.allowance;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.model.allowance.Allowance;
import world.deslauriers.model.allowance.AllowanceDto;
import world.deslauriers.model.allowance.DashboardDto;
import world.deslauriers.service.allowance.AllowanceService;

import javax.validation.Valid;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/allowance/allowances")
public class AllowanceController {

    protected final AllowanceService allowanceService;

    public AllowanceController(AllowanceService allowanceService) {
        this.allowanceService = allowanceService;
    }


    @Secured({"ALLOWANCE_ADMIN"})
    @Get
    Flux<AllowanceDto> getAll(){
        return allowanceService.getAll();
    }

        @Get("/dashboard")
    Mono<DashboardDto> getAllowanceDashboard(){
        return allowanceService.getAllowanceDashboard();
    }

    @Secured({"ALLOWANCE_ADMIN", "ALLOWANCE_USER"})
    @Post
    Mono<HttpResponse<Allowance>> save(@Body @Valid Allowance cmd){
        return allowanceService.saveAllownace(cmd);
    }
}
