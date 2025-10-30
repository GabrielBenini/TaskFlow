package com.gbenini.TaskFlow.repository;

import com.gbenini.TaskFlow.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository <Task, Long> {
}
