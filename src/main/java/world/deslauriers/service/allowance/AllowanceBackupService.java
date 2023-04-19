package world.deslauriers.service.allowance;

import reactor.core.publisher.Flux;
import world.deslauriers.model.allowance.*;

public interface AllowanceBackupService {
    Flux<BackupAllowance> getAllowanceBackup();

    Flux<BackupTasktype> getTasktypeBackup();

    Flux<BackupTask> getTaskBackup();

    Flux<BackupTasktypeAllowance> getTasktypeAlowanceBackups();

    Flux<BackupTaskAllowance> getTaskAlowanceBackups();
}
