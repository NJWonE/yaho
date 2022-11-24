package com.noh.yaho.todolist.command.application.service;

import com.noh.yaho.todolist.command.application.dto.TodolistDTO;
import com.noh.yaho.todolist.command.domain.model.Todolist;
import com.noh.yaho.todolist.command.domain.repository.TagRepository;
import com.noh.yaho.todolist.command.domain.repository.TodolistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TodolistService {

    private final TodolistRepository todolistRepository;
    private final TagRepository tagRepository;
    @Transactional
    public int registTodolist(TodolistDTO todolistDTO) {
        Todolist newTodolist = new Todolist(todolistDTO.getMemberNo(), todolistDTO.getProjectNo(),
                todolistDTO.getDueDate(), todolistDTO.getTitle(), todolistDTO.getContent(), tagRepository.findById(todolistDTO.getTagNo()).get());
        todolistRepository.save(newTodolist);
        return newTodolist.getTodolistNo();
    }

    @Transactional
    public int updateTodolist(TodolistDTO todolistDTO) {
        Todolist findTodolist = todolistRepository.findById(todolistDTO.getTodolistNo()).get();
        findTodolist.setTag(tagRepository.findById(2).get());
        todolistRepository.save(findTodolist);
        return findTodolist.getTodolistNo();
    }
}
