package world.deslauriers.service.allowance;

import jakarta.inject.Singleton;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.client.AllowanceFetcher;
import world.deslauriers.model.allowance.*;

@Singleton
public class AllowanceBackupServiceImpl implements AllowanceBackupService {

    private final AllowanceFetcher allowanceFetcher;

    public AllowanceBackupServiceImpl(AllowanceFetcher allowanceFetcher) {
        this.allowanceFetcher = allowanceFetcher;
    }

    @Override
    public Flux<BackupAllowance> getAllowanceBackup(Long epoch) {
        return allowanceFetcher.backupAllowances(epoch);
    }

    @Override
    public Flux<BackupTasktype> getTasktypeBackup(Long epoch) {
        return allowanceFetcher.backupTasktypes(epoch);
    }

    @Override
    public Flux<BackupTask> getTaskBackup(Long epoch) {
        return allowanceFetcher.backupTasks(epoch);
    }

    @Override
    public Flux<BackupTasktypeAllowance> getTasktypeAlowanceBackups(Long epoch) {
        return allowanceFetcher.backupTasktypeAllowance(epoch);
    }

    @Override
    public Flux<BackupTaskAllowance> getTaskAlowanceBackups(Long epoch) {
        return allowanceFetcher.backupTaskAllowance(epoch);
    }

    @Override
    public Mono<DeleteRecordsDto> cleanupRecords(Long epoch) {
        return allowanceFetcher.cleanupRecords(epoch);
    }
}
