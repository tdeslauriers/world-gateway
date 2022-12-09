package world.deslauriers.model.allowance;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record TaskDto(
        Long id,
        String task,
        String cadence,
        String category,
        String date,
        Boolean isComplete,
        Boolean isQuality
) {
}
