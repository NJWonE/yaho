package com.noh.yaho.todolist.command.application.controller;

import com.noh.yaho.common.dto.ResponseDTO;
import com.noh.yaho.todolist.command.application.dto.TodolistDTO;
import com.noh.yaho.todolist.command.application.service.TodolistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todolist")
public class TodolistCommandController {

    private final TodolistService todolistService;

    @PostMapping
    public ResponseDTO registTodolist(@RequestBody TodolistDTO todolistDTO){
        return new ResponseDTO(HttpStatus.OK, "todolist 생성 성공", todolistService.registTodolist(todolistDTO));
    }
}
