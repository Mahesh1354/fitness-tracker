package com.project.fitness.dto;

import com.project.fitness.model.ActivityType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityRequest {

    @NotBlank(message = "User ID is required")
    private String userId;

    @NotNull(message = "Activity type is required")
    private ActivityType type;

    private Map<String, Object> additionalMetrics;

    @NotNull(message = "Duration is required")
    @Positive(message = "Duration must be greater than zero")
    private Integer duration;

    @NotNull(message = "Calories burned is required")
    @Positive(message = "Calories burned must be greater than zero")
    private Integer caloriesBurned;

    @NotNull(message = "Start time is required")
    private LocalDateTime startTime;
}
