package com.hourscontrol.hourscontrol.services;

import com.hourscontrol.hourscontrol.dtos.request.TaskDTO;
import com.hourscontrol.hourscontrol.dtos.response.ActivityResponse;
import com.hourscontrol.hourscontrol.dtos.response.MessageResponseDTO;
import com.hourscontrol.hourscontrol.dtos.response.TaskResponse;
import com.hourscontrol.hourscontrol.entities.Activity;
import com.hourscontrol.hourscontrol.entities.Task;
import com.hourscontrol.hourscontrol.exceptions.TaskNotFoundException;
import com.hourscontrol.hourscontrol.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<TaskResponse> getAllTasks() {
        List<TaskResponse> tasksResponseList = new ArrayList<>();
        List<Task> tasks = taskRepository.findAll();

        tasks.forEach(task -> tasksResponseList.add(convertTaskToTaskResponse(task)));
        return tasksResponseList;
    }

    public MessageResponseDTO editTask(Long id, TaskDTO taskDTO) throws TaskNotFoundException {
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        task.setTaskName(taskDTO.getTaskName());
        task.setTaskDescription(taskDTO.getTaskDescription());
        taskRepository.save(task);

        return MessageResponseDTO
                .builder()
                .message("Tarefa atualizada com sucesso")
                .build();
    }

    private TaskResponse convertTaskToTaskResponse(Task task){
        return TaskResponse
                .builder()
                .id(task.getTaskId())
                .taskName(task.getTaskName())
                .taskDescription(task.getTaskDescription())
                .activities(
                        task.getActivities()
                        .stream()
                        .map(ActivityResponse::convertActivityToActivityResponse)
                        .collect(Collectors.toList()))
                .build();
    }

}
