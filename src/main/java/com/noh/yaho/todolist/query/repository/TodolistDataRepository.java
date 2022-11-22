package com.noh.yaho.todolist.query.repository;

import com.noh.yaho.todolist.query.data.TagData;
import com.noh.yaho.todolist.query.data.TodolistData;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TodolistDataRepository extends JpaRepository<TodolistData, Integer> {
    List<TodolistData> findByMemberNoAndProjectNo(int memberNo, int projectNo);
    List<TodolistData> findByMemberNoAndProjectNoAndTagNo(int memberNo, int projectNo, TagData tagNo);
    List<TodolistData> findByMemberNo(int memberNo);
    List<TodolistData> findByMemberNoAndTagNo(int memberNo, TagData tagNo);
}
