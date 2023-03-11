package com.uapp.task.oleg.trello.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "columns")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Column {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private int position;
    private int userId;
}
