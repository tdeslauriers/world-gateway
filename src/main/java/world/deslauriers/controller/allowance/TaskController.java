package world.deslauriers.controller.allowance;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Put;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.model.allowance.CompleteQualityCmd;
import world.deslauriers.model.allowance.TaskDto;
import world.deslauriers.service.allowance.TaskService;

import javax.validation.Valid;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/allowance/tasks")
public class TaskController {

    protected final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Secured({ "ALLOWANCE_USER"})
    @Get("/daily")
    Flux<TaskDto> getDailyTasks(){
        return taskService.getDailyTasks();
    }

    @Secured({ "ALLOWANCE_ADMIN"})
    @Get("/inspect")
    Flux<?> getInspectionTasks(){
        return taskService.getInspectionTasks();
    }

    @Secured({"ALLOWANCE_ADMIN", "ALLOWANCE_USER"})
    @Put("/complete")
    Mono<HttpResponse> updateIsComplete(@Body @Valid CompleteQualityCmd cmd){
        return taskService.updateTaskComplete(cmd);
    }

    @Secured({"ALLOWANCE_ADMIN" })
    @Put("/quality")
    Mono<HttpResponse> updateIsCQuality(@Body @Valid CompleteQualityCmd cmd){
        return taskService.updateTaskQuality(cmd);
    }
}
