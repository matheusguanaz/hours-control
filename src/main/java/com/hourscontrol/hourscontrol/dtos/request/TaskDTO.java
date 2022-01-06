package com.hourscontrol.hourscontrol.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {

    @NotEmpty
    private Long projectId;

    @NotEmpty
    private String taskName;

    private String taskDescription;
}
