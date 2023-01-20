package world.deslauriers.model.allowance;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.micronaut.serde.annotation.Serdeable;

import java.time.LocalDate;
@Serdeable
public record TaskDto(
        Long id,
        String task,
        String cadence,
        String category,
        String date,
        Boolean complete,
        Boolean satisfactory
) {
}
