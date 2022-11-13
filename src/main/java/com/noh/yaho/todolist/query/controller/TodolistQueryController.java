package com.noh.yaho.todolist.query.controller;

import com.noh.yaho.common.dto.ResponseDTO;
import com.noh.yaho.todolist.query.service.TodolistQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todolist")
public class TodolistQueryController {

    private final TodolistQueryService todolistQueryService;

    @GetMapping
    public ResponseDTO selectTodolist(@RequestParam(name="memberNo", required = false, defaultValue = "0")int memberNo,
                                                            @RequestParam(name="projectNo", required = false, defaultValue = "0")int projectNo,
                                                            @RequestParam(name="tagNo", required = false, defaultValue = "0")int tagNo){
            return new ResponseDTO(HttpStatus.OK, "todolist 조회 성공", todolistQueryService.selectTodolist(memberNo, projectNo, tagNo));
    }
}
