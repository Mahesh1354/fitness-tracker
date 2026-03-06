package com.project.fitness.service;

import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.ActivityResponse;
import com.project.fitness.exception.ResourceNotFoundException;
import com.project.fitness.model.Activity;
import com.project.fitness.model.User;
import com.project.fitness.repository.ActivityRepository;
import com.project.fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;

    @Transactional
    public ActivityResponse createActivity(ActivityRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("User", "id", request.getUserId()));

        Activity activity = Activity.builder()
                .user(user)
                .type(request.getType())
                .duration(request.getDuration())
                .caloriesBurned(request.getCaloriesBurned())
                .additionalMetrics(request.getAdditionalMetrics())
                .startTime(request.getStartTime())
                .build();

        Activity savedActivity = activityRepository.saveAndFlush(activity);
        return toResponse(savedActivity);

    }

    @Transactional(readOnly = true)
    public List<ActivityResponse> getUserActivities(String userId) {

        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User", "id", userId);
        }

        List<Activity> activities = activityRepository.findByUserId(userId);

        return activities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ActivityResponse getActivityById(String id) {
        Activity activity = activityRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Activity", "id", id));
        return toResponse(activity);
    }

    @Transactional
    public void deleteActivity(String id) {
        if (!activityRepository.existsById(id)) {
            throw new ResourceNotFoundException("Activity", "id", id);
        }
        activityRepository.deleteById(id);
    }

    private ActivityResponse toResponse(Activity activity) {
        return ActivityResponse.builder()
                .id(activity.getId())
                .userId(activity.getUser().getId())
                .type(activity.getType())
                .duration(activity.getDuration())
                .caloriesBurned(activity.getCaloriesBurned())
                .additionalMetrics(activity.getAdditionalMetrics())
                .startTime(activity.getStartTime())
                .createdAt(activity.getCreatedAt())
                .updatedAt(activity.getUpdatedAt())
                .build();
    }
}
