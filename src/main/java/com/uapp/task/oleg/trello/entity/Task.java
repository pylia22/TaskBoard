package com.uapp.task.oleg.trello.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
