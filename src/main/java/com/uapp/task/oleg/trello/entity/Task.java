package com.uapp.task.oleg.trello.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@Getter
@Setter
public class Task {

    @Id
    private int id;
    private String name;
    private String description;
    private int position;
    private LocalDate creationDate;
    private int columnId;
}
