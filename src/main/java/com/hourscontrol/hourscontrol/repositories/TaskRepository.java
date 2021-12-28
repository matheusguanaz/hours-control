package com.hourscontrol.hourscontrol.repositories;

import com.hourscontrol.hourscontrol.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
