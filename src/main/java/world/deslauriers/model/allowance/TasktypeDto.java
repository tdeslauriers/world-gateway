package world.deslauriers.model.allowance;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;

@Serdeable
public record TasktypeDto(

        @Nullable Long id,
        @NonNull String name,
        @NonNull String cadence,
        @NonNull String category,
        @NonNull Boolean archived,
        @Nullable Set<AllowanceDto> allowances
) {
}
