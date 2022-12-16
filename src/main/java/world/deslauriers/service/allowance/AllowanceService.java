package world.deslauriers.service.allowance;

import io.micronaut.http.HttpResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.model.allowance.Allowance;
import world.deslauriers.model.allowance.AllowanceDto;

public interface AllowanceService {
    Flux<AllowanceDto> getAll();

    Mono<HttpResponse<Allowance>> saveAllownace(Allowance cmd);
}
