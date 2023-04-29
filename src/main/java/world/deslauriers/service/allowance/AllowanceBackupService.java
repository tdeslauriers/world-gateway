package world.deslauriers.service.allowance;

import reactor.core.publisher.Flux;
import world.deslauriers.model.allowance.*;

public interface AllowanceBackupService {
    Flux<BackupAllowance> getAllowanceBackup(Long epoch);

    Flux<BackupTasktype> getTasktypeBackup(Long epoch);

    Flux<BackupTask> getTaskBackup(Long epoch);

    Flux<BackupTasktypeAllowance> getTasktypeAlowanceBackups(Long epoch);

    Flux<BackupTaskAllowance> getTaskAlowanceBackups(Long epoch);
}
