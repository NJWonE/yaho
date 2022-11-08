package com.noh.yaho.todolist.query.controller;

import com.noh.yaho.common.dto.ResponseDTO;
import com.noh.yaho.todolist.query.service.TodolistQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/todolist")
public class TodolistQueryController {

    private final TodolistQueryService todolistQueryService;

    @GetMapping
    public ResponseDTO selectTodolistByMemberNoAndProjectNo(@RequestParam(name="memberNo")int memberNo,
                                                            @RequestParam(name="projectNo")int projectNo){
        return new ResponseDTO(HttpStatus.OK, "todolist 조회 성공", todolistQueryService.selectTodolistByMemberNoAndProjectNo(memberNo, projectNo));
    }
}
