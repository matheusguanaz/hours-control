package com.hourscontrol.hourscontrol.services;

import com.hourscontrol.hourscontrol.dtos.request.TaskDTO;
import com.hourscontrol.hourscontrol.dtos.response.MessageResponseDTO;
import com.hourscontrol.hourscontrol.entities.Task;
import com.hourscontrol.hourscontrol.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TaskService {

    private TaskRepository taskRepository;

    public MessageResponseDTO createTask(TaskDTO taskDTO){
        Task task = new Task();
        task.setTaskDescription(taskDTO.getTaskDescription());
        task.setTaskName(taskDTO.getTaskName());

        taskRepository.save(task);

        return MessageResponseDTO
                .builder()
                .message("Tarefa criada com sucesso")
                .build();
    }

}
