package world.deslauriers.model.allowance;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.micronaut.serde.annotation.Serdeable;

import java.time.LocalDate;
@Serdeable
public record TaskDto(
        Long id,
        String name,
        String cadence,
        String category,
        Boolean archived,
        String date,
        Boolean complete,
        Boolean satisfactory
) {
}
