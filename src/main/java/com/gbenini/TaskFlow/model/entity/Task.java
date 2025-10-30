package com.gbenini.TaskFlow.model.entity;

import com.gbenini.TaskFlow.model.enumerate.statusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "tb_tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private statusEnum status;

    @Column(name = "created_at")
    private Instant createdAt;

}
