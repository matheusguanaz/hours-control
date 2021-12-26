package com.hourscontrol.hourscontrol.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ActiviyyResponse {
    private Long activityId;

    private String description;

    private Date startTime;

    private Date endTime;
}
