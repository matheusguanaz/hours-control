package com.hourscontrol.hourscontrol.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TaskNotFoundException  extends Exception{
    public TaskNotFoundException(Long id){
        super("Task with id " + id + " not found");
    }
}
