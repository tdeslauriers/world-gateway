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


    @Get("/allowances")
    public Flux<BackupAllowance> backupAllowances(){
        return allowanceBackupService.getAllowanceBackup();
    }

    @Get("/tasktypes")
    public Flux<BackupTasktype> backupTasktypes() {
        return allowanceBackupService.getTasktypeBackup();
    }

    @Get("/tasks")
    public Flux<BackupTask> backupTasks(){ return allowanceBackupService.getTaskBackup(); }

    @Get("/tasktypeAllowances")
    public Flux<BackupTasktypeAllowance> backupTasktypeAllowance() { return allowanceBackupService.getTasktypeAlowanceBackups(); }

    @Get("/taskAllowances")
    public Flux<BackupTaskAllowance> backupTaskAllowance() { return allowanceBackupService.getTaskAlowanceBackups(); }
}
