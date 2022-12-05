package world.deslauriers.client;

import io.micronaut.http.HttpResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.model.allowance.*;

public interface AllowanceFetcher {

    // allowances
    Mono<Allowance> getTasksByALlowanceId(Long id);
    Mono<HttpResponse<Allowance>> saveAllownace(Allowance cmd);

    // tasktypes
    Flux<Tasktype> getAllTasktypes();
    Flux<Tasktype> getTasktypesByAllowanceId(Long id);
    Mono<HttpResponse<Tasktype>> saveTasktype(Tasktype cmd);
    Mono<HttpResponse<Tasktype>> updateTasktype(Tasktype cmd);
    Mono<HttpResponse> assignTaskType(AssignTaskCmd cmd);
    Flux<TaskDto> getDailyTasks(Long allowanceId);

    // tasks
    Mono<TaskDto> getTaskById(Long id);
    Mono<HttpResponse> updateTaskComplete(CompleteQualityCmd cmd);
    Mono<HttpResponse> updateTaskQuality(CompleteQualityCmd cmd);
}
