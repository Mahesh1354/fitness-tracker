package com.project.fitness.controller;

import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.ActivityResponse;
import com.project.fitness.service.ActivityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Activity APIs", description = "APIs for tracking fitness activities")
@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;


    @Operation(
            summary = "Create a new activity",
            description = "Creates and stores a fitness activity for a logged-in user"
    )
    // Create / Track activity
    @PostMapping
    public ResponseEntity<ActivityResponse> trackActivity(@Valid @RequestBody ActivityRequest request) {

        ActivityResponse response = activityService.createActivity(request);
        return ResponseEntity.ok(response);
    }



    @Operation(summary = "Get activities for a user")
    @ApiResponse(responseCode = "200", description = "Activities fetched successfully")
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    @ApiResponse(responseCode = "403", description = "Forbidden")
    // Get all activities
    @GetMapping
    public ResponseEntity<List<ActivityResponse>> getAllActivities(
            @RequestHeader("userId") String userId) {

        List<ActivityResponse> responses = activityService.getUserActivities(userId);
        return ResponseEntity.ok(responses);
    }
}
