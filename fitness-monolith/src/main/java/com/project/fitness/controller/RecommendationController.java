package com.project.fitness.controller;

import com.project.fitness.dto.RecommendationRequest;
import com.project.fitness.model.Recommendation;
import com.project.fitness.service.RecommendationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;

    // Generate recommendation
    @PostMapping("/generate")
    public ResponseEntity<Recommendation> generateRecommendation(
           @Valid @RequestBody RecommendationRequest request) {

        Recommendation recommendation =
                recommendationService.generateRecommendation(request);

        return ResponseEntity.ok(recommendation);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Recommendation>> getUserRecommendation(
            @PathVariable String userId) {

        List<Recommendation> recommendations =
                recommendationService.getUserRecommendation(userId);

        return ResponseEntity.ok(recommendations);
    }

    // Get recommendations by activity
    @GetMapping("/activity/{activityId}")
    public ResponseEntity<List<Recommendation>> getActivityRecommendation(
            @PathVariable String activityId) {

        List<Recommendation> recommendations =
                recommendationService.getActivityRecommendation(activityId);

        return ResponseEntity.ok(recommendations);
    }
}
