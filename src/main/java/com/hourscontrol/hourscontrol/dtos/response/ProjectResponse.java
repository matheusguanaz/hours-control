package com.hourscontrol.hourscontrol.dtos.response;

import com.hourscontrol.hourscontrol.entities.Project;
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
public class ProjectResponse {

    private Long projectId;

    private String projectName;

    private String projectDescription;

    private List<TaskResponse> tasks;

    public static ProjectResponse convertProjectToProjectResponse(Project project){
        return ProjectResponse
                .builder()
                .projectId(project.getProjectId())
                .projectName(project.getProjectName())
                .projectDescription(project.getProjectDescription())
                .tasks(
                        project.getTasks()
                                .stream()
                                .map(TaskResponse::convertTaskToTaskResponse)
                                .collect(Collectors.toList())
                )
                .build();
    }

}
