package com.uapp.task.oleg.trello.repository;

import com.uapp.task.oleg.trello.entity.Column;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ColumnRepository extends JpaRepository<Column, Integer> {
    Optional<Column> findColumnByName(String name);
}
