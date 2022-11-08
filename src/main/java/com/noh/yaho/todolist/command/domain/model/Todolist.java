package com.noh.yaho.todolist.command.domain.model;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="TBL_TODOLIST")
@SequenceGenerator(
        name = "TODOLIST_SEQUENCE",
        sequenceName = "SEQ_TODOLIST_SEQUENCE",
        initialValue = 1,
        allocationSize = 1

)
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class Todolist {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TODOLIST_SEQUENCE")
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

    public Todolist(int memberNo, int projectNo, Date dueDate, String title, String content) {
        this.memberNo = memberNo;
        this.projectNo = projectNo;
        this.dueDate = dueDate;
        this.title = title;
        this.content = content;
    }
}
