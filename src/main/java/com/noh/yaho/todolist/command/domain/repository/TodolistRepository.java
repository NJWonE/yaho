package com.noh.yaho.todolist.command.domain.repository;

import com.noh.yaho.todolist.command.domain.model.Todolist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodolistRepository extends JpaRepository<Todolist, Integer> {
}
