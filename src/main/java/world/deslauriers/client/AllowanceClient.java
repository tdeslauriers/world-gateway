package world.deslauriers.client;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.client.annotation.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.model.allowance.*;

@Client(id = "allowance")
public interface AllowanceClient extends AllowanceFetcher{

    // allowances
//    @Override
//    @Get("/allowances")
//    Mono<Allowance> getTasksByALlowanceId(Long id);
    @Override
    @Get("/allowances")
    Flux<Allowance> getAllowances();

    @Override
    @Post("/allowances")
    Mono<HttpResponse<Allowance>> saveAllowance(@Body Allowance cmd);

    // tasktypes
    @Override
    @Get("/tasktypes")
    Flux<Tasktype> getAllTasktypes();

    @Override
    @Get("/tasktypes/{id}")
    Mono<Tasktype> getTasktypeById(Long id);

//    @Override
//    @Get("/tasktypes/{id}")
//    Flux<Tasktype> getTasktypesByAllowanceId(Long id);

    @Override
    @Post("/tasktypes")
    Mono<HttpResponse<Tasktype>> saveTasktype(@Body Tasktype cmd);

    @Override
    @Put("/tasktypes")
    Mono<HttpResponse<Tasktype>> updateTasktype(@Body Tasktype cmd);

    @Override
    @Put("/tasktypes/archive")
    Mono<HttpResponse<Tasktype>> archiveTasktype(@Body ArchiveCmd cmd);

    @Override
    @Post("/tasktypes/assign")
    Mono<HttpResponse> assignTaskType(@Body AssignTaskCmd cmd);

//    @Override
//    @Get("/tasktypes/daily/{allowanceId}")
//    Flux<TaskDto> getDailyTasks(Long allowanceId);

    // tasks
//    @Override
//    @Get("/tasks/{id}")
//    Mono<TaskDto> getTaskById(Long id);

    @Override
    @Put("/tasks/complete")
    Mono<HttpResponse> updateTaskComplete(@Body CompleteQualityCmd cmd);

    @Override
    @Put("/tasks/quality")
    Mono<HttpResponse> updateTaskQuality(@Body CompleteQualityCmd cmd);

}
