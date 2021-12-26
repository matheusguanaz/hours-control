package com.hourscontrol.hourscontrol.services;

import com.hourscontrol.hourscontrol.dtos.request.EndActivityRequestDTO;
import com.hourscontrol.hourscontrol.dtos.response.CreateMessageResponseDTO;
import com.hourscontrol.hourscontrol.dtos.response.MessageResponseDTO;
import com.hourscontrol.hourscontrol.entities.Activity;
import com.hourscontrol.hourscontrol.exceptions.ActivityNotFoundException;
import com.hourscontrol.hourscontrol.repositories.ActivityRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ActivityService {

    private ActivityRepository activityRepository;

    public CreateMessageResponseDTO createActivity(){
        Activity activity = new Activity();
        activity.setStartTime(new Timestamp(System.currentTimeMillis()));
        Activity savedActivity = activityRepository.save(activity);

        return CreateMessageResponseDTO
                .builder()
                .message("Atividade iniciada com sucesso ")
                .activityId(savedActivity.getActivityId())
                .build();
    }

    public MessageResponseDTO endActivity(Long id, EndActivityRequestDTO endActivityRequestDTO) throws ActivityNotFoundException {
        Activity activity = activityRepository.findById(id).orElseThrow(() -> new ActivityNotFoundException(id));
        activity.setEndTime(new Timestamp(System.currentTimeMillis()));
        activity.setDescription(endActivityRequestDTO.getDescription());
        activityRepository.save(activity);
        return MessageResponseDTO
                .builder()
                .message("Atividade encerrada com sucesso")
                .build();
    }
}
