package com.hourscontrol.hourscontrol.repositories;

import com.hourscontrol.hourscontrol.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository <Activity, Long> {
}
