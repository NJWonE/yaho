package com.noh.yaho.todolist.command.application.service;

import com.noh.yaho.todolist.command.application.dto.TodolistDTO;
import com.noh.yaho.todolist.command.domain.model.Todolist;
import com.noh.yaho.todolist.command.domain.repository.TodolistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TodolistRegistService {

    private final TodolistRepository todolistRepository;
    @Transactional
    public int registTodolist(TodolistDTO todolistDTO) {
        Todolist newTodolist = new Todolist(todolistDTO.getMemberNo(), todolistDTO.getProjectNo(),
                todolistDTO.getDueDate(), todolistDTO.getTitle(), todolistDTO.getContent());
        todolistRepository.save(newTodolist);
        return newTodolist.getTodolistNo();
    }
}
