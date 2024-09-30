package com.helloLoiNguyen.springJwt.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "task")
@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "taskDescription")
    private String taskDescription;

    @Column(name = "assignedDate")
    private LocalDateTime assignedDate;

    @Column(name = "dueDate")
    private LocalDateTime dueDate;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
