package world.deslauriers.service.allowance;

import io.micronaut.http.HttpResponse;
import io.micronaut.security.authentication.Authentication;
import jakarta.inject.Singleton;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.client.AllowanceFetcher;
import world.deslauriers.model.allowance.CompleteQualityCmd;
import world.deslauriers.model.allowance.TaskDto;

@Singleton
public class TaskServiceImpl implements TaskService {

    private final AllowanceFetcher allowanceFetcher;

    public TaskServiceImpl(AllowanceFetcher allowanceFetcher) {
        this.allowanceFetcher = allowanceFetcher;
    }


    @Override
    public Flux<TaskDto> getDailyTasks() {
        // token propagation informs allowance service of user identity.
        return allowanceFetcher.getDailyTasks();
    }

    @Override
    public Mono<HttpResponse> updateTaskComplete(CompleteQualityCmd cmd) {
        return allowanceFetcher.updateTaskComplete(cmd);
    }

    @Override
    public Mono<HttpResponse> updateTaskQuality(CompleteQualityCmd cmd) {
        return allowanceFetcher.updateTaskQuality(cmd);
    }
}
