package com.noh.yaho.todolist.query.service;

import com.noh.yaho.todolist.command.domain.model.Todolist;
import com.noh.yaho.todolist.query.data.TodolistData;
import com.noh.yaho.todolist.query.exception.TodolistQueryException;
import com.noh.yaho.todolist.query.repository.TagQueryRepository;
import com.noh.yaho.todolist.query.repository.TodolistQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodolistQueryService {

    private final TodolistQueryRepository todolistQueryRepository;

    private final TagQueryRepository tagQueryRepository;


    public List<TodolistData> selectTodolist(int memberNo, int projectNo, int tagNo) {
        List<TodolistData> todolistData = new ArrayList<>();
        if(memberNo!=0&&projectNo!=0&&tagNo!=0){
            todolistData = todolistQueryRepository.findByMemberNoAndProjectNoAndTagNo(memberNo, projectNo, tagQueryRepository.findById(tagNo).get());
        }else if(memberNo!=0&&projectNo!=0&&tagNo==0){
            todolistData = todolistQueryRepository.findByMemberNoAndProjectNo(memberNo, projectNo);
        }else if(memberNo!=0&&projectNo==0&&tagNo!=0){
            todolistData = todolistQueryRepository.findByMemberNoAndTagNo(memberNo, tagQueryRepository.findById(tagNo).get());
        }else{
            todolistData = todolistQueryRepository.findByMemberNo(memberNo);
        }

        if (todolistData.isEmpty()) {
            throw new TodolistQueryException("조회할 수 없습니다.");
        }
        return todolistData;
    }
}
