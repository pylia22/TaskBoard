package com.uapp.task.oleg.trello.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "columns")
@Getter
@Setter
public class Column {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private int position;
    private int userId;
}
