package com.noh.yaho.todolist.command.application.controller;

import com.noh.yaho.common.dto.ResponseDTO;
import com.noh.yaho.todolist.command.application.dto.TodolistDTO;
import com.noh.yaho.todolist.command.application.service.TodolistService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "TODOLIST", description = "TODOLIST 생성, 수정, 조회 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/todolist")
public class TodolistCommandController {

    private final TodolistService todolistService;

    @Operation(description = "todolist를 생성하기 위해 필요한 값을 전달 받는다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @Parameters({
            @Parameter(name = "memberNo", description = "멤버 번호", example = "45"),
            @Parameter(name = "projectNo", description = "프로젝트 번호", example = "1"),
            @Parameter(name = "title", description = "todolist 제목", example = "UI 작업"),
            @Parameter(name = "content", description = "todolist 내용", example = "프로젝트 홈 UI 작업"),
            @Parameter(name = "dueDate", description = "마감 날짜", example = "2022-11-11"),
            @Parameter(name = "tagNo", description = "태그 번호", example = "1")
    })
    @PostMapping
    public ResponseDTO registTodolist(@RequestBody TodolistDTO todolistDTO){
        return new ResponseDTO(HttpStatus.OK, "todolist 생성 성공", todolistService.registTodolist(todolistDTO));
    }

    @PutMapping
    public ResponseDTO updateTodolist(@RequestBody TodolistDTO todolistDTO){
        return new ResponseDTO(HttpStatus.OK, "todolist 태그 완료로 변경 성공", todolistService.updateTodolist(todolistDTO));
    }
}
