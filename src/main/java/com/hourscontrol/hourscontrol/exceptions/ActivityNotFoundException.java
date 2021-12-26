package com.hourscontrol.hourscontrol.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ActivityNotFoundException extends Exception {
    public ActivityNotFoundException(Long id){
        super("Activity with not found with id" + id);
    }
}
