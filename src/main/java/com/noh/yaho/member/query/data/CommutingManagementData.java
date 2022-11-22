package com.noh.yaho.member.query.data;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="TBL_COMMUTING_MANAGEMENT")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CommutingManagementData {

    @Id
    @Column(name="COMMUTING_MANAGEMENT_NO")
    private int commutingManagementNo;

    @Column(name="ATTENDANCE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private java.util.Date attendanceTime;

    @Column(name="LEAVE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date leaveTime;

    @Column(name="MEMBER_NO")
    private int memberNo;

    @JoinColumn(name="WORK_TIME_NO")
    @OneToMany
    private List<WorkTimeData> workTimeList;

}
