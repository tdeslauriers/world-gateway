package world.deslauriers.service.allowance;

import io.micronaut.http.HttpResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.model.allowance.Allowance;
import world.deslauriers.model.allowance.AllowanceDto;
import world.deslauriers.model.allowance.DashboardDto;

public interface AllowanceService {
    Flux<AllowanceDto> getAll();

    Mono<DashboardDto> getAllowanceDashboard();

    Mono<HttpResponse<Allowance>> saveAllownace(Allowance cmd);

}
