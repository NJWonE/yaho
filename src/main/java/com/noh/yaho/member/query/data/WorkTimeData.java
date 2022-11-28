package com.noh.yaho.member.query.data;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="TBL_WORK_TIME")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class WorkTimeData {
    @Id
    @Column(name="WORK_TIME_NO")
    private int workTimeNo;

    @Column(name="WORK_START_TIME")
    private java.util.Date workStartTime;

    @Column(name="WORK_END_TIME")
    private java.util.Date workEndTime;

    @Column(name="MEMBER_NO")
    private int memberNo;
}
