package com.noh.yaho.todolist.query.repository;

import com.noh.yaho.todolist.command.domain.model.Todolist;
import com.noh.yaho.todolist.query.data.TodolistData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodolistQueryRepository extends JpaRepository<TodolistData, Integer> {
    List<Todolist> findByMemberNoAndProjectNo(int memberNo, int projectNo);
}
