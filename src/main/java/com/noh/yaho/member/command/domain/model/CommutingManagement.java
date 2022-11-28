package com.noh.yaho.member.command.domain.model;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="TBL_COMMUTING_MANAGEMENT")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@SequenceGenerator(
        name="COMMUTING_MANAGEMENT",
        sequenceName = "SEQ_COMMUTING_MANAGEMENT",
        initialValue = 1,
        allocationSize = 1
)
public class CommutingManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMUTING_MANAGEMENT")
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

    public CommutingManagement(Date attendanceTime, int memberNo) {
        this.attendanceTime = attendanceTime;
        this.memberNo = memberNo;
    }

    public CommutingManagement(int memberNo) {
        this.memberNo = memberNo;
    }

    public CommutingManagement(Date attendanceTime, Date leaveTime, int memberNo) {
        this.attendanceTime = attendanceTime;
        this.leaveTime = leaveTime;
        this.memberNo = memberNo;
    }
}
