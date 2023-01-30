package world.deslauriers.client;

import io.micronaut.http.HttpResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.model.allowance.*;

public interface AllowanceFetcher {

    // allowances
    Flux<Allowance> getAllowances();
    Mono<HttpResponse<Allowance>> saveAllowance(Allowance cmd);

    // tasktypes
    Flux<Tasktype> getAllTasktypes();
    Mono<Tasktype> getTasktypeById(Long id);
    Mono<HttpResponse<Tasktype>> saveTasktype(Tasktype cmd);
    Mono<HttpResponse<Tasktype>> updateTasktype(Tasktype cmd);

    // tasks
    Flux<TaskDto> getDailyTasks();
    Mono<HttpResponse> updateTaskComplete(CompleteQualityCmd cmd);
    Mono<HttpResponse> updateTaskQuality(CompleteQualityCmd cmd);


}
