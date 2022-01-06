package com.hourscontrol.hourscontrol.repositories;

import com.hourscontrol.hourscontrol.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
