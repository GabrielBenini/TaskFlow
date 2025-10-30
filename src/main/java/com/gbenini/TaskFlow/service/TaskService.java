package com.gbenini.TaskFlow.service;

import com.gbenini.TaskFlow.exception.ResourceNotFoundException;
import com.gbenini.TaskFlow.model.dto.TaskRequestDTO;
import com.gbenini.TaskFlow.model.dto.TaskResponseDTO;
import com.gbenini.TaskFlow.model.entity.Task;
import com.gbenini.TaskFlow.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskResponseDTO createTask(TaskRequestDTO requestDTO){

        Task task = requestDTO.toEntity();

        taskRepository.save(task);

        return TaskResponseDTO.fromEntity(task);

    }

    public Page<TaskResponseDTO> listAllTasks(Pageable pageable){

        return taskRepository.findAll(pageable)
                .map(TaskResponseDTO::fromEntity);

    }

    public TaskResponseDTO findTaskById(Long id){

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));

        return TaskResponseDTO.fromEntity(task);

    }

    public TaskResponseDTO updateTaskById(Long id, TaskRequestDTO requestDTO){

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));

        task.setTitle(requestDTO.title());
        task.setDescription(requestDTO.description());
        task.setStatus(requestDTO.status());

        taskRepository.save(task);

        return TaskResponseDTO.fromEntity(task);

    }

    public void deleteTaskById(Long id){

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));

        taskRepository.delete(task);

    }

}
