package world.deslauriers.service.allowance;

import jakarta.inject.Singleton;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.client.AllowanceFetcher;
import world.deslauriers.client.AuthFetcher;
import world.deslauriers.model.allowance.AllowanceDto;
import world.deslauriers.model.allowance.Tasktype;
import world.deslauriers.model.allowance.TasktypeAllowance;
import world.deslauriers.model.allowance.TasktypeDto;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.stream.Collectors;

@Singleton
public class TasktypeServiceImpl implements TasktypeService{

    private final AllowanceFetcher allowanceFetcher;
    private final AuthFetcher authFetcher;


    public TasktypeServiceImpl(AllowanceFetcher allowanceFetcher, AuthFetcher authFetcher) {
        this.allowanceFetcher = allowanceFetcher;
        this.authFetcher = authFetcher;
    }

    @Override
    public Flux<TasktypeDto> getTasktypesAll(){

        return allowanceFetcher
                .getAllTasktypes()
                .map(tasktype -> {
                    return new TasktypeDto(
                            tasktype.id(),
                            tasktype.name(),
                            tasktype.cadence(),
                            tasktype.category(),
                            tasktype.archived(),
                            collectAllowances(tasktype));
                });
    }

    @Override
    public Mono<TasktypeDto> getTasktypeById(Long id) {
        return allowanceFetcher
                .getTasktypeById(id)
                .map(tasktype -> {
                    return new TasktypeDto(
                            tasktype.id(),
                            tasktype.name(),
                            tasktype.cadence(),
                            tasktype.category(),
                            tasktype.archived(),
                            collectAllowances(tasktype));
                });
    }

    private HashSet<AllowanceDto> collectAllowances(Tasktype tasktype){
        var allowances = new HashSet<AllowanceDto>();
        if (tasktype.tasktypeAllowances() != null) {
            var a = Flux.fromStream(tasktype.tasktypeAllowances()
                    .stream()
                    .map(tasktypeAllowance -> {
                        return authFetcher
                                .getProfileByUuid(tasktypeAllowance.allowance().userUuid())
                                .map(profile -> {
                                    return new AllowanceDto(
                                            tasktypeAllowance.allowance().id(),
                                            tasktypeAllowance.allowance().balance(),
                                            profile.uuid(),
                                            profile.username(),
                                            profile.firstname(),
                                            profile.lastname(),
                                            Period.between(LocalDate.parse(profile.birthday()), LocalDate.now()).getYears()
                                    );
                                })
                                .block();
                    }))
                    .doOnNext(allowances::add)
                    .blockLast();
        }
        return allowances;
    }

}
