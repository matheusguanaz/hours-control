package com.hourscontrol.hourscontrol.controllers;

import com.hourscontrol.hourscontrol.dtos.request.ProjectDTO;
import com.hourscontrol.hourscontrol.dtos.response.MessageResponseDTO;
import com.hourscontrol.hourscontrol.dtos.response.ProjectResponse;
import com.hourscontrol.hourscontrol.exceptions.ProjectNotFoundException;
import com.hourscontrol.hourscontrol.services.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/project")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProjectController {

    private ProjectService projectService;

    @PostMapping
    public MessageResponseDTO createProject(@RequestBody ProjectDTO projectDTO){
        return projectService.createProject(projectDTO);
    }

    @GetMapping
    public List<ProjectResponse> getAllProjects(){
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public ProjectResponse getOneProject(@PathVariable Long id) throws ProjectNotFoundException {
        return projectService.getOneProjectById(id);
    }
}
