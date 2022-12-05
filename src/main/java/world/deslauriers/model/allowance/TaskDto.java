package world.deslauriers.model.allowance;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record TaskDto(
        Long id,
        String task,
        String cadence,
        String date,
        Boolean isComplete,
        Boolean isQuality
) {
}
