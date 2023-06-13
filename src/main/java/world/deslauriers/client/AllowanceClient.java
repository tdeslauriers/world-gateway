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
    @Get("/backup/allowances/{epoch}")
    Flux<BackupAllowance> backupAllowances(Long epoch);

    @Override
    @Get("/backup/tasktypes/{epoch}")
    Flux<BackupTasktype> backupTasktypes(Long epoch);

    @Override
    @Get("/backup/tasks/{epoch}")
    Flux<BackupTask> backupTasks(Long epoch);

    @Override
    @Get("/backup/tasktype_allowances/{epoch}")
    Flux<BackupTasktypeAllowance> backupTasktypeAllowance(Long epoch);

    @Override
    @Get("/backup/task_allowances/{epoch}")
    Flux<BackupTaskAllowance> backupTaskAllowance(Long epoch);

    @Override
    @Get("/backup/cleanup/{epoch}")
    Mono<DeleteRecordsDto> cleanupRecords(Long epoch);

    // restore
    @Override
    @Post("/restore/allowance")
    Mono<HttpResponse<?>> restoreAllowance(@Body BackupAllowance backupAllowance);

    @Override
    @Post("/restore/tasktype")
    Mono<HttpResponse<?>> restoreTasktype(@Body BackupTasktype backupTasktype);
    @Override
    @Post("/restore/task")
    Mono<HttpResponse<?>> restoreTask(@Body BackupTask backupTask);

    @Override
    @Post("/restore/tasktype_allowance")
    Mono<HttpResponse<?>> restoreTasktypeAllowance(@Body BackupTasktypeAllowance backupTasktypeAllowance);

    @Override
    @Post("/restore/task_allowance")
    Mono<HttpResponse<?>> restoreTaskAllowance(@Body BackupTaskAllowance backupTaskAllowance);
}
