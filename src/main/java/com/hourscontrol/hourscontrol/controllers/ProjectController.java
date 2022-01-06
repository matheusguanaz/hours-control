package com.hourscontrol.hourscontrol.controllers;

import com.hourscontrol.hourscontrol.dtos.request.ProjectDTO;
import com.hourscontrol.hourscontrol.dtos.response.MessageResponseDTO;
import com.hourscontrol.hourscontrol.services.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/project")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProjectController {

    private ProjectService projectService;

    @PostMapping
    public MessageResponseDTO createProject(@RequestBody ProjectDTO projectDTO){
        return projectService.createProject(projectDTO);
    }
}
