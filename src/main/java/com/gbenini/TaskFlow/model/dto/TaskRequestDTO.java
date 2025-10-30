package com.gbenini.TaskFlow.model.dto;

import com.gbenini.TaskFlow.model.entity.Task;
import com.gbenini.TaskFlow.model.enumerate.statusEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TaskRequestDTO(

        @NotBlank(message = "Title cannot be blank")
        String title,
        @NotBlank(message = "Description cannot be blank")
        String description,
        @NotNull(message = "Status cannot be null")
        statusEnum status) {

    public Task toEntity(){

        Task task = new Task();

        task.setTitle(this.title);
        task.setDescription(this.description);
        task.setStatus(this.status);

        return task;

    }

}
