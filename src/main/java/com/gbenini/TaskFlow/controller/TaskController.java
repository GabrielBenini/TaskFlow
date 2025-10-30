package com.gbenini.TaskFlow.controller;

import com.gbenini.TaskFlow.model.dto.TaskRequestDTO;
import com.gbenini.TaskFlow.model.dto.TaskResponseDTO;
import com.gbenini.TaskFlow.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody @Valid TaskRequestDTO requestDTO){

        TaskResponseDTO responseDTO = taskService.createTask(requestDTO);

        return ResponseEntity.ok(responseDTO);

    }

    @GetMapping
    public ResponseEntity<Page<TaskResponseDTO>> listAllTasks(Pageable pageable){

        Page<TaskResponseDTO> responseDTO = taskService.listAllTasks(pageable);
        return ResponseEntity.ok(responseDTO);

    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> findTaskById(@PathVariable("id") Long id){

        TaskResponseDTO responseDTO = taskService.findTaskById(id);

        return ResponseEntity.ok(responseDTO);

    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> updateTaskById(@PathVariable("id") Long id, @RequestBody TaskRequestDTO requestDTO){

        TaskResponseDTO responseDTO = taskService.updateTaskById(id, requestDTO);

        return ResponseEntity.ok(responseDTO);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable("id") Long id){

        taskService.deleteTaskById(id);

        return ResponseEntity.noContent().build();

    }

}
