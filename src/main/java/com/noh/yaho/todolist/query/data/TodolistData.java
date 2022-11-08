package com.noh.yaho.todolist.query.data;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="TBL_TODOLIST")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class TodolistData {

    @Id
    @Column(name="TODOLIST_NO")
    private int todolistNo;

    @Column(name="MEMBER_NO")
    private int memberNo;

    @Column(name="PROJECT_NO")
    private int projectNo;

    @Column(name="DEU_DATE")
    @Temporal(TemporalType.DATE)
    private java.util.Date dueDate;

    @Column(name="TITLE")
    private String title;

    @Column(name="CONTENT")
    private String content;
}
