package com.hourscontrol.hourscontrol.services;

import com.hourscontrol.hourscontrol.dtos.request.ProjectDTO;
import com.hourscontrol.hourscontrol.dtos.response.MessageResponseDTO;
import com.hourscontrol.hourscontrol.dtos.response.ProjectResponse;
import com.hourscontrol.hourscontrol.dtos.response.TaskResponse;
import com.hourscontrol.hourscontrol.entities.Project;
import com.hourscontrol.hourscontrol.entities.Task;
import com.hourscontrol.hourscontrol.exceptions.ProjectNotFoundException;
import com.hourscontrol.hourscontrol.exceptions.TaskNotFoundException;
import com.hourscontrol.hourscontrol.repositories.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProjectService {

    private ProjectRepository projectRepository;

    public MessageResponseDTO createProject(ProjectDTO projectDTO){
        Project project = new Project();
        project.setProjectName(projectDTO.getProjectName());
        project.setProjectDescription(projectDTO.getProjectDescription());

        projectRepository.save(project);

        return MessageResponseDTO
                .builder()
                .message("Projeto criado com sucesso")
                .build();
    }

    public List<ProjectResponse> getAllProjects() {
        List<ProjectResponse> projectResponseList = new ArrayList<>();
        List<Project> projects = projectRepository.findAll();

        projects.forEach(project -> projectResponseList.add(ProjectResponse.convertProjectToProjectResponse(project)));

        return projectResponseList;
    }

    public ProjectResponse getOneProjectById(Long id) throws ProjectNotFoundException {
        Project project = verifyIfProjectExists(id);
        return ProjectResponse.convertProjectToProjectResponse(project);
    }

    public MessageResponseDTO editProject(Long id, ProjectDTO projectDTO) throws ProjectNotFoundException {
        Project project = verifyIfProjectExists(id);
        project.setProjectName(projectDTO.getProjectName());
        project.setProjectDescription(projectDTO.getProjectDescription());

        projectRepository.save(project);
        return MessageResponseDTO
                .builder()
                .message("Projeto atualizado com sucesso")
                .build();
    }

    private Project verifyIfProjectExists(Long id) throws ProjectNotFoundException {
        return projectRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException(id));
    }

    public void deleteProject(Long id) throws ProjectNotFoundException {
        projectRepository.delete(verifyIfProjectExists(id));
    }
}
