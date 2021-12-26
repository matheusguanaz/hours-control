package com.hourscontrol.hourscontrol.controllers;

import com.hourscontrol.hourscontrol.dtos.request.ActivityDTO;
import com.hourscontrol.hourscontrol.dtos.request.EndActivityRequestDTO;
import com.hourscontrol.hourscontrol.dtos.response.CreateMessageResponseDTO;
import com.hourscontrol.hourscontrol.dtos.response.MessageResponseDTO;
import com.hourscontrol.hourscontrol.exceptions.ActivityNotFoundException;
import com.hourscontrol.hourscontrol.services.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1/activity")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ActivityController {

    private ActivityService activityService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateMessageResponseDTO createActivity(){
        return activityService.createActivity();
    }

    @PatchMapping("/{id}")
    public MessageResponseDTO endActivity(@PathVariable Long id, @RequestBody EndActivityRequestDTO endActivityRequestDTO) throws ActivityNotFoundException {
        return activityService.endActivity(id, endActivityRequestDTO);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO editActivity(@PathVariable Long id, @RequestBody ActivityDTO activityDTO) throws ActivityNotFoundException {
        return activityService.editActivity(id, activityDTO);
    }
}
