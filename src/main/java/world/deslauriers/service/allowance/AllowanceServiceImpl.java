package world.deslauriers.service.allowance;

import io.micronaut.http.HttpResponse;
import jakarta.inject.Singleton;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.client.AllowanceFetcher;
import world.deslauriers.client.AuthFetcher;
import world.deslauriers.model.allowance.Allowance;
import world.deslauriers.model.allowance.AllowanceDto;
import world.deslauriers.model.allowance.DashboardDto;

import java.time.LocalDate;
import java.time.Period;

@Singleton
public class AllowanceServiceImpl implements AllowanceService{

    private final AllowanceFetcher allowanceFetcher;
    private final AuthFetcher authFetcher;

    public AllowanceServiceImpl(AllowanceFetcher allowanceFetcher, AuthFetcher authFetcher) {
        this.allowanceFetcher = allowanceFetcher;
        this.authFetcher = authFetcher;
    }

    @Override
    public Flux<AllowanceDto> getAll() {
        return allowanceFetcher
                .getAllowances()
                .flatMap(allowance -> {
                    return authFetcher
                            .getProfileByUuid(allowance.userUuid())
                            .flatMap(profile -> {
                                var age = Period.between(LocalDate.parse(profile.birthday()), LocalDate.now());
                                return Mono.just(new AllowanceDto(
                                        allowance.id(),
                                        allowance.balance(),
                                        profile.uuid(),
                                        profile.username(),
                                        profile.firstname(),
                                        profile.lastname(),
                                        age.getYears()));
                            });
                });
    }

    @Override
    public Mono<DashboardDto> getAllowanceDashboard() {

        return authFetcher.getUserProfile()
                .zipWith(allowanceFetcher.getAllowanceDashboard())
                .flatMap(objects -> {
                    var profile = objects.getT1();
                    var metrics = objects.getT2();

                    metrics.setId(profile.id());
                    metrics.setUsername(profile.username());
                    metrics.setFirstname(profile.firstname());
                    metrics.setLastname(profile.lastname());
                    metrics.setAge(Period.between(LocalDate.parse(profile.birthday()), LocalDate.now()).getYears());

                    return Mono.just(metrics);
                });
    }

    @Override
    public Mono<HttpResponse<Allowance>> saveAllownace(Allowance cmd) {
        return allowanceFetcher.saveAllowance(cmd);
    }
}
