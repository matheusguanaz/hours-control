package com.hourscontrol.hourscontrol.dtos.response;

import com.hourscontrol.hourscontrol.entities.Activity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ActivityResponse {
    private Long activityId;

    private String description;

    private Date startTime;

    private Date endTime;

    public static ActivityResponse convertActivityToActivityResponse(Activity activity){
        return ActivityResponse
                .builder()
                .activityId(activity.getActivityId())
                .description(activity.getDescription())
                .startTime(activity.getStartTime())
                .endTime(activity.getEndTime())
                .build();
    }
}
