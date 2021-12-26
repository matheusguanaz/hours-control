package com.hourscontrol.hourscontrol.dtos.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateMessageResponseDTO {
    private String message;
    private Long activityId;
}
