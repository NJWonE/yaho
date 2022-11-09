package com.noh.yaho.todolist.command.application.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TodolistDTO {
    private int memberNo;
    private int projectNo;
    private String title;
    private String content;
    private java.util.Date dueDate;
    private int tagNo;
}
