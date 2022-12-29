package world.deslauriers.service.allowance;

import io.micronaut.http.HttpResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.model.allowance.CompleteQualityCmd;
import world.deslauriers.model.allowance.TaskDto;

public interface TaskService {

    Flux<TaskDto> getDailyTasks();

    Mono<HttpResponse> updateTaskComplete(CompleteQualityCmd cmd);

    Mono<HttpResponse> updateTaskQuality(CompleteQualityCmd cmd);
}
