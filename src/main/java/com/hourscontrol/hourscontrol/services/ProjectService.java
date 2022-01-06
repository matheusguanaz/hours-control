package com.hourscontrol.hourscontrol.services;

import com.hourscontrol.hourscontrol.dtos.request.ProjectDTO;
import com.hourscontrol.hourscontrol.dtos.response.MessageResponseDTO;
import com.hourscontrol.hourscontrol.entities.Project;
import com.hourscontrol.hourscontrol.repositories.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
