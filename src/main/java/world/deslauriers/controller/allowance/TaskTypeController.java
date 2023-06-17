package world.deslauriers.controller.allowance;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.client.AllowanceFetcher;
import world.deslauriers.model.allowance.*;
import world.deslauriers.service.allowance.TasktypeService;

import javax.validation.Valid;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/allowance/tasktypes")
public class TaskTypeController {

    protected final AllowanceFetcher allowanceFetcher;
    protected final TasktypeService tasktypeService;

    public TaskTypeController(AllowanceFetcher allowanceFetcher, TasktypeService tasktypeService) {
        this.allowanceFetcher = allowanceFetcher;
        this.tasktypeService = tasktypeService;
    }

    @Secured({"ALLOWANCE_ADMIN"})
    @Get
    Flux<TasktypeDto> getAll(){
        return tasktypeService.getTasktypesAll();
    }

    @Secured({"ALLOWANCE_ADMIN"})
    @Get("/{id}")
    Mono<TasktypeDto> getById(Long id){
        return tasktypeService.getTasktypeById(id);
    }

    @Secured({"ALLOWANCE_ADMIN"})
    @Post
    Mono<HttpResponse<TasktypeDto>> save(@Body @Valid TasktypeDto cmd){

        return tasktypeService.saveTasktype(cmd);
    }

    @Secured({"ALLOWANCE_ADMIN"})
    @Put
    Mono<HttpResponse<TasktypeDto>> update(@Body @Valid TasktypeDto cmd){
        return tasktypeService.updateTasktype(cmd);
    }

    @Secured({"ALLOWANCE_ADMIN"})
    @Put("/remove/tasktype/allowance")
    Mono<HttpResponse> removeTasktypeAllowance(@Body @Valid RemoveTasktypeAllowanceCmd cmd){
        return tasktypeService.removeTasktypeAllowance(cmd);
    }
}
