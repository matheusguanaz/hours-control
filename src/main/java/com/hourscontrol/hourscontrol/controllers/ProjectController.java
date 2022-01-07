package com.hourscontrol.hourscontrol.controllers;

import com.hourscontrol.hourscontrol.dtos.request.ProjectDTO;
import com.hourscontrol.hourscontrol.dtos.response.MessageResponseDTO;
import com.hourscontrol.hourscontrol.dtos.response.ProjectResponse;
import com.hourscontrol.hourscontrol.exceptions.ProjectNotFoundException;
import com.hourscontrol.hourscontrol.services.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PutMapping("/{id}")
    public MessageResponseDTO editProject(@PathVariable Long id, @RequestBody ProjectDTO projectDTO) throws ProjectNotFoundException {
        return projectService.editProject(id, projectDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProject(@PathVariable Long id) throws ProjectNotFoundException {
        projectService.deleteProject(id);
    }
}
