package world.deslauriers.service.allowance;

import jakarta.inject.Singleton;
import reactor.core.publisher.Flux;
import world.deslauriers.client.AllowanceFetcher;
import world.deslauriers.model.allowance.*;

@Singleton
public class AllowanceBackupServiceImpl implements AllowanceBackupService {

    private final AllowanceFetcher allowanceFetcher;

    public AllowanceBackupServiceImpl(AllowanceFetcher allowanceFetcher) {
        this.allowanceFetcher = allowanceFetcher;
    }

    @Override
    public Flux<BackupAllowance> getAllowanceBackup() {
        return allowanceFetcher.backupAllowances();
    }

    @Override
    public Flux<BackupTasktype> getTasktypeBackup() {
        return allowanceFetcher.backupTasktypes();
    }

    @Override
    public Flux<BackupTask> getTaskBackup() {
        return allowanceFetcher.backupTasks();
    }

    @Override
    public Flux<BackupTasktypeAllowance> getTasktypeAlowanceBackups() {
        return allowanceFetcher.backupTasktypeAllowance();
    }

    @Override
    public Flux<BackupTaskAllowance> getTaskAlowanceBackups() {
        return allowanceFetcher.backupTaskAllowance();
    }
}
