package com.hourscontrol.hourscontrol.services;

import com.hourscontrol.hourscontrol.dtos.request.ActivityDTO;
import com.hourscontrol.hourscontrol.dtos.request.EndActivityRequestDTO;
import com.hourscontrol.hourscontrol.dtos.response.ActiviyyResponse;
import com.hourscontrol.hourscontrol.dtos.response.CreateMessageResponseDTO;
import com.hourscontrol.hourscontrol.dtos.response.MessageResponseDTO;
import com.hourscontrol.hourscontrol.entities.Activity;
import com.hourscontrol.hourscontrol.exceptions.ActivityNotFoundException;
import com.hourscontrol.hourscontrol.repositories.ActivityRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
        Activity activity = verifyIfActivityExists(id);
        activity.setEndTime(new Timestamp(System.currentTimeMillis()));
        activity.setDescription(endActivityRequestDTO.getDescription());
        activityRepository.save(activity);
        return MessageResponseDTO
                .builder()
                .message("Atividade encerrada com sucesso")
                .build();
    }

    public List<ActiviyyResponse> getAllActivities() {
        List<ActiviyyResponse> activityResponseList = new ArrayList<>();
        List<Activity> activities = activityRepository.findAll();

        activities.forEach(activity -> activityResponseList.add(convertActivityToActivyResponse(activity)));
        return activityResponseList;
    }

    public ActiviyyResponse getOne(Long id) throws ActivityNotFoundException {
        return convertActivityToActivyResponse(verifyIfActivityExists(id));
    }

    public MessageResponseDTO editActivity(Long id, ActivityDTO activityDTO) throws ActivityNotFoundException {
        Activity activity = verifyIfActivityExists(id);
        activity.setDescription(activityDTO.getDescription());
        activity.setStartTime(formatTimestampFromString(activityDTO.getStartTime()));
        activity.setEndTime(formatTimestampFromString(activityDTO.getEndTime()));
        activityRepository.save(activity);

        return MessageResponseDTO
                .builder()
                .message("Atividade alterada com sucesso")
                .build();
    }

    public void deleteActivity(Long id) throws ActivityNotFoundException {
        activityRepository.delete(verifyIfActivityExists(id));
    }

    private Activity verifyIfActivityExists(Long id) throws ActivityNotFoundException {
        Activity activity = activityRepository.findById(id).orElseThrow(() -> new ActivityNotFoundException(id));
        return activity;
    }

    private Timestamp formatTimestampFromString(String date){
        return Timestamp.valueOf(date);
    }

    private ActiviyyResponse convertActivityToActivyResponse(Activity activity){
        return ActiviyyResponse
                .builder()
                .activityId(activity.getActivityId())
                .description(activity.getDescription())
                .startTime(activity.getStartTime())
                .endTime(activity.getEndTime())
                .build();
    }

}
