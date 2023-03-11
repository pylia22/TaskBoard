package com.uapp.task.oleg.trello.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    private int id;
    private String username;
    private String password;
    private String role;
}
