package world.deslauriers.controller.allowance;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.client.AllowanceFetcher;
import world.deslauriers.model.allowance.AssignTaskCmd;
import world.deslauriers.model.allowance.Task;
import world.deslauriers.model.allowance.TaskDto;
import world.deslauriers.model.allowance.Tasktype;

import javax.validation.Valid;

@Secured({"ALLOWANCE_ADMIN"})
@Controller("/allowance/tasktypes")
public class TaskTypeController {

    protected final AllowanceFetcher allowanceFetcher;

    public TaskTypeController(AllowanceFetcher allowanceFetcher) {
        this.allowanceFetcher = allowanceFetcher;
    }

    @Get
    Flux<Tasktype> getAll(){
        return allowanceFetcher.getAllTasktypes();
    }

    @Get("/{id}")
    Flux<Tasktype> getByAllowanceId(Long id){
        return allowanceFetcher.getTasktypesByAllowanceId(id);
    }

    @Post
    Mono<HttpResponse<Tasktype>> save(@Body Tasktype cmd){
        return allowanceFetcher.saveTasktype(cmd);
    }

    @Put
    Mono<HttpResponse<Tasktype>> update(@Body @Valid Tasktype cmd){
        return allowanceFetcher.updateTasktype(cmd);
    }

    @Post("/assign")
    Mono<HttpResponse> assignTask(@Body @Valid AssignTaskCmd cmd){
        return allowanceFetcher.assignTaskType(cmd);
    }

    @Get("/daily/{allowanceId}")
    Flux<TaskDto> getDailyTasks(Long allowanceId){
        return allowanceFetcher.getDailyTasks(allowanceId);
    }
}
