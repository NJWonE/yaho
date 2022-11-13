package com.noh.yaho.todolist.query.service;

import com.noh.yaho.todolist.query.data.TodolistData;
import com.noh.yaho.todolist.query.exception.TodolistQueryException;
import com.noh.yaho.todolist.query.repository.TagDataRepository;
import com.noh.yaho.todolist.query.repository.TodolistDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodolistQueryService {

    private final TodolistDataRepository todolistDataRepository;

    private final TagDataRepository tagDataRepository;

    public List<TodolistData> selectTodolist(int memberNo, int projectNo, int tagNo) {
        List<TodolistData> todolistData = new ArrayList<>();
        if(memberNo!=0&&projectNo!=0&&tagNo!=0){
            todolistData = todolistDataRepository.findByMemberNoAndProjectNoAndTagNo(memberNo, projectNo, tagDataRepository.findById(tagNo).get());
        }else if(memberNo!=0&&projectNo!=0&&tagNo==0){
            todolistData = todolistDataRepository.findByMemberNoAndProjectNo(memberNo, projectNo);
        }else if(memberNo!=0&&projectNo==0&&tagNo!=0){
            todolistData = todolistDataRepository.findByMemberNoAndTagNo(memberNo, tagDataRepository.findById(tagNo).get());
        }else{
            todolistData = todolistDataRepository.findByMemberNo(memberNo);
        }

        if (todolistData.isEmpty()) {
            throw new TodolistQueryException("조회할 수 없습니다.");
        }
        return todolistData;
    }
}
