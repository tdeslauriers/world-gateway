package world.deslauriers.service.allowance;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.model.allowance.Tasktype;
import world.deslauriers.model.allowance.TasktypeDto;

public interface TasktypeService {
    Flux<TasktypeDto> getTasktypesAll();

    Mono<TasktypeDto> getTasktypeById(Long id);
}
