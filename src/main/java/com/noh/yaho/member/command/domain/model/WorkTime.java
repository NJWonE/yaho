package com.noh.yaho.member.command.domain.model;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="TBL_WORK_TIME")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(
        name="WORK_TIME",
        sequenceName = "SEQ_WORK_TIME",
        initialValue = 1,
        allocationSize = 1
)
public class WorkTime {

    @Id
    @Column(name="WORK_TIME_NO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WORK_TIME")
    private int workTimeNo;

    @Column(name="WORK_START_TIME")
    private java.util.Date workStartTime;

    @Column(name="WORK_END_TIME")
    private java.util.Date workEndTime;

    @Column(name="MEMBER_NO")
    private int memberNo;

    public WorkTime(int memberNo, Date workStartTime, Date workEndTime) {
        this.memberNo = memberNo;
        this.workStartTime = workStartTime;
        this.workEndTime = workEndTime;
    }
}
