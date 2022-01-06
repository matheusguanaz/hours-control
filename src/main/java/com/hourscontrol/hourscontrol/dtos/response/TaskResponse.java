package com.hourscontrol.hourscontrol.dtos.response;

import com.hourscontrol.hourscontrol.dtos.request.ActivityDTO;
import com.hourscontrol.hourscontrol.entities.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponse {

    private Long taskId;

    private String taskName;

    private String taskDescription;

    private List<ActivityResponse> activities;

    public static TaskResponse convertTaskToTaskResponse(Task task){
        return TaskResponse
                .builder()
                .taskId(task.getTaskId())
                .taskName(task.getTaskName())
                .taskDescription(task.getTaskDescription())
                .activities(
                        task.getActivities()
                                .stream()
                                .map(ActivityResponse::convertActivityToActivityResponse)
                                .collect(Collectors.toList()))
                .build();
    }
}
