package com.hourscontrol.hourscontrol.dtos.request;

import com.hourscontrol.hourscontrol.dtos.response.ActivityResponse;
import com.hourscontrol.hourscontrol.entities.Activity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivityDTO {
    @NotEmpty
    private String description;

    @NotEmpty
    private String startTime;

    @NotEmpty
    private String endTime;

    @NotEmpty
    private  Long taskId;

}
