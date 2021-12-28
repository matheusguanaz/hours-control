package com.hourscontrol.hourscontrol.dtos.response;

import com.hourscontrol.hourscontrol.dtos.request.ActivityDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponse {

    private Long id;

    private String taskName;

    private String taskDescription;

    private List<ActivityResponse> activities;
}
