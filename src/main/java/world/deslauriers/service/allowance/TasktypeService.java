package world.deslauriers.service.allowance;

import io.micronaut.http.HttpResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.model.allowance.RemoveTasktypeAllowanceCmd;
import world.deslauriers.model.allowance.Tasktype;
import world.deslauriers.model.allowance.TasktypeDto;

public interface TasktypeService {
    Flux<TasktypeDto> getTasktypesAll();

    Mono<TasktypeDto> getTasktypeById(Long id);

    Mono<HttpResponse<TasktypeDto>> updateTasktype(TasktypeDto cmd);

    Mono<HttpResponse<TasktypeDto>> saveTasktype(TasktypeDto cmd);

    Mono<HttpResponse> removeTasktypeAllowance(RemoveTasktypeAllowanceCmd cmd);
}
