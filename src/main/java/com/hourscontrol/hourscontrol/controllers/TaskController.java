package com.hourscontrol.hourscontrol.controllers;

import com.hourscontrol.hourscontrol.dtos.request.TaskDTO;
import com.hourscontrol.hourscontrol.dtos.response.MessageResponseDTO;
import com.hourscontrol.hourscontrol.dtos.response.TaskResponse;
import com.hourscontrol.hourscontrol.entities.Task;
import com.hourscontrol.hourscontrol.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/task")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TaskController {

    private TaskService taskService;

    @PostMapping
    public MessageResponseDTO createTask(@RequestBody TaskDTO taskDTO){
        return taskService.createTask(taskDTO);
    }

    @GetMapping
    public List<TaskResponse> getAllTasks(){
        return taskService.getAllTasks();
    }
}
