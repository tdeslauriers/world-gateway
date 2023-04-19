package world.deslauriers.client;

import io.micronaut.http.HttpResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.model.allowance.*;

public interface AllowanceFetcher {

    // allowances
    Flux<Allowance> getAllowances();
    Mono<HttpResponse<Allowance>> saveAllowance(Allowance cmd);
    Mono<DashboardDto> getAllowanceDashboard();

    // tasktypes
    Flux<Tasktype> getAllTasktypes();
    Mono<Tasktype> getTasktypeById(Long id);
    Mono<HttpResponse<Tasktype>> saveTasktype(Tasktype cmd);
    Mono<HttpResponse<Tasktype>> updateTasktype(Tasktype cmd);
    Mono<HttpResponse> removeTasktypeAllowance(RemoveTasktypeAllowanceCmd cmd);

    // tasks
    Flux<TaskDto> getDailyTasks();
    Flux<TaskDto> getUserDailyTasks(String uuid);
    Mono<HttpResponse> updateTaskComplete(CompleteQualityCmd cmd);
    Mono<HttpResponse> updateTaskQuality(CompleteQualityCmd cmd);

    // backups
    Flux<BackupAllowance> backupAllowances();
    Flux<BackupTasktype> backupTasktypes();
    Flux<BackupTask> backupTasks();
    Flux<BackupTasktypeAllowance> backupTasktypeAllowance();
    Flux<BackupTaskAllowance> backupTaskAllowance();

}
