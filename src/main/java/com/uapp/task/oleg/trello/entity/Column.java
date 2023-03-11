package com.uapp.task.oleg.trello.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "columns")
@Getter
@Setter
public class Column {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @NotNull
    private String name;
    private int position;
    private int userId;
}
