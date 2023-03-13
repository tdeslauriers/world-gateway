package world.deslauriers.service.allowance;

import io.micronaut.http.HttpResponse;
import jakarta.inject.Singleton;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.client.AllowanceFetcher;
import world.deslauriers.model.allowance.AllowanceDto;
import world.deslauriers.model.allowance.CompleteQualityCmd;
import world.deslauriers.model.allowance.TaskDto;

import java.util.Collections;
import java.util.HashSet;

@Singleton
public class TaskServiceImpl implements TaskService {

    private final AllowanceFetcher allowanceFetcher;
    private final AllowanceService allowanceService;

    public TaskServiceImpl(AllowanceFetcher allowanceFetcher, AllowanceService allowanceService) {
        this.allowanceFetcher = allowanceFetcher;
        this.allowanceService = allowanceService;
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

    @Override
    public Flux<?> getInspectionTasks() {
        return allowanceService.getAll()
                .map(allowanceDto -> {
                    var tasks = new HashSet<TaskDto>();
                    allowanceFetcher.getUserDailyTasks(allowanceDto.getUserUuid())
                            .doOnNext(tasks::add)
                            .blockLast();
                    allowanceDto.setTasks(tasks);
                    return allowanceDto;
                });
    }
}
