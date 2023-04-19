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
    @Override
    @Get("/allowances")
    Flux<Allowance> getAllowances();

    @Override
    @Post("/allowances")
    Mono<HttpResponse<Allowance>> saveAllowance(@Body Allowance cmd);

    @Override
    @Get("/allowances/dashboard")
    Mono<DashboardDto> getAllowanceDashboard();

    // tasktypes
    @Override
    @Get("/tasktypes")
    Flux<Tasktype> getAllTasktypes();

    @Override
    @Get("/tasktypes/{id}")
    Mono<Tasktype> getTasktypeById(Long id);

    @Override
    @Post("/tasktypes")
    Mono<HttpResponse<Tasktype>> saveTasktype(@Body Tasktype cmd);

    @Override
    @Put("/tasktypes")
    Mono<HttpResponse<Tasktype>> updateTasktype(@Body Tasktype cmd);

    @Override
    @Put("/tasktypes/remove/tasktype/allowance")
    Mono<HttpResponse> removeTasktypeAllowance(@Body RemoveTasktypeAllowanceCmd cmd);

    // tasks
    @Override
    @Get("/tasks/daily")
    Flux<TaskDto> getDailyTasks();

    @Override
    @Get("/tasks/daily/{uuid}")
    Flux<TaskDto> getUserDailyTasks(String uuid);

    @Override
    @Put("/tasks/complete")
    Mono<HttpResponse> updateTaskComplete(@Body CompleteQualityCmd cmd);

    @Override
    @Put("/tasks/quality")
    Mono<HttpResponse> updateTaskQuality(@Body CompleteQualityCmd cmd);

    // backup
    @Override
    @Get("/backup/allowances")
    Flux<BackupAllowance> backupAllowances();

    @Override
    @Get("/backup/tasktypes")
    Flux<BackupTasktype> backupTasktypes();

    @Override
    @Get("/backup/tasks")
    Flux<BackupTask> backupTasks();

    @Override
    @Get("/backup/tasktypeAllowances")
    Flux<BackupTasktypeAllowance> backupTasktypeAllowance();

    @Override
    @Get("/backup/taskAllowances")
    Flux<BackupTaskAllowance> backupTaskAllowance();
}
