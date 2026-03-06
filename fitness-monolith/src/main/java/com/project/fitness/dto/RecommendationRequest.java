package com.project.fitness.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationRequest {

    @NotBlank(message = "User ID is required")
    private String userId;

    @NotBlank(message = "Activity ID is required")
    private String activityId;

    @NotBlank(message = "Recommendation type is required")
    private String type;

    private List<String> improvements;
    private List<String> suggestions;
    private List<String> safety;
}
