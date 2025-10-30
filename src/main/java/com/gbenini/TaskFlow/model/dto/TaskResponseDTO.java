package com.gbenini.TaskFlow.model.dto;

import com.gbenini.TaskFlow.model.entity.Task;
import com.gbenini.TaskFlow.model.enumerate.statusEnum;

import java.time.Instant;

public record TaskResponseDTO(Long id, String title, String description, statusEnum status, Instant createdAt) {

    public static TaskResponseDTO fromEntity(Task task){

        return new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getCreatedAt()

        );

    }

}
