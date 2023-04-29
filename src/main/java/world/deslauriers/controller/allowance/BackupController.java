package world.deslauriers.controller.allowance;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import world.deslauriers.model.allowance.*;
import world.deslauriers.service.allowance.AllowanceBackupService;


@Secured({"COLD_STORAGE"})
@Controller("/allowance/backup")
public class BackupController {

    private static final Logger log = LoggerFactory.getLogger(BackupController.class);

    private final AllowanceBackupService allowanceBackupService;

    public BackupController(AllowanceBackupService allowanceBackupService) {
        this.allowanceBackupService = allowanceBackupService;
    }


    @Get("/allowances/{epoch}")
    public Flux<BackupAllowance> backupAllowances(Long epoch){
        return allowanceBackupService.getAllowanceBackup(epoch);
    }

    @Get("/tasktypes/{epoch}")
    public Flux<BackupTasktype> backupTasktypes(Long epoch) {
        return allowanceBackupService.getTasktypeBackup(epoch);
    }

    @Get("/tasks/{epoch}")
    public Flux<BackupTask> backupTasks(Long epoch){
        return allowanceBackupService.getTaskBackup(epoch);
    }

    @Get("/tasktype_allowances/{epoch}")
    public Flux<BackupTasktypeAllowance> backupTasktypeAllowance(Long epoch) {
        return allowanceBackupService.getTasktypeAlowanceBackups(epoch);
    }

    @Get("/task_allowances/{epoch}")
    public Flux<BackupTaskAllowance> backupTaskAllowance(Long epoch) {
        return allowanceBackupService.getTaskAlowanceBackups(epoch);
    }
}
