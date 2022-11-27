package com.noh.yaho.checklist.command.domain.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

@Entity
@Table(name="TBL_DAILY_GRAPH")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(
        name="DAILY_GRAPH_SEQUENCE",
        sequenceName = "SEQ_DAILY_GRAPH_SEQUENCE",
        initialValue = 1,
        allocationSize = 1
)
public class DailyGraph {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DAILY_GRAPH_SEQUENCE")
    @Column(name="DAILY_GRAPH_NO")
    private int dailyGraphNo;

    @Column(name="MEMBER_NO")
    private int memberNo;

    @Column(name="CREATE_DATE")
    @CreationTimestamp
    private java.util.Date createDate;

    @Column(name="PROJECT_NO")
    private int projectNo;

    @Column(name="IMAGE_URL")
    private String imageURL;

    public DailyGraph(int memberNo, int projectNo, String imageURL) {
        this.memberNo = memberNo;
        this.projectNo = projectNo;
        this.imageURL = imageURL;
    }
}
