package world.deslauriers.controller.allowance;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Put;
import io.micronaut.security.annotation.Secured;
import reactor.core.publisher.Mono;
import world.deslauriers.client.AllowanceFetcher;
import world.deslauriers.model.allowance.CompleteQualityCmd;
import world.deslauriers.model.allowance.TaskDto;

import javax.validation.Valid;

@Secured({"ALLOWANCE_ADMIN, ALLOWANCE_USER"})
@Controller("/allowance/tasks")
public class TaskController {

    protected final AllowanceFetcher allowanceFetcher;

    public TaskController(AllowanceFetcher allowanceFetcher) {
        this.allowanceFetcher = allowanceFetcher;
    }

    @Get("/{id}")
    Mono<TaskDto> getById(Long id){
        return allowanceFetcher.getTaskById(id);
    }

    @Put("/complete")
    Mono<HttpResponse> updateIsComplete(@Body @Valid CompleteQualityCmd cmd){
        return allowanceFetcher.updateTaskComplete(cmd);
    }

    @Put("/quality")
    Mono<HttpResponse> updateIsCQuality(@Body @Valid CompleteQualityCmd cmd){
        return allowanceFetcher.updateTaskQuality(cmd);
    }
}
