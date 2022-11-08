package com.noh.yaho.todolist.query.service;

import com.noh.yaho.todolist.command.domain.model.Todolist;
import com.noh.yaho.todolist.query.repository.TodolistQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodolistQueryService {

    private final TodolistQueryRepository todolistQueryRepository;


    public List<Todolist> selectTodolistByMemberNoAndProjectNo(int memberNo, int projectNo) {
        return todolistQueryRepository.findByMemberNoAndProjectNo(memberNo, projectNo);
    }
}
