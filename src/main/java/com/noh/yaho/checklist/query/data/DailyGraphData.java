package com.noh.yaho.checklist.query.data;

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
public class DailyGraphData {

    @Id
    @Column(name="DAILY_GRAPH_NO")
    private int dailyGraphNo;

    @Column(name="MEMBER_NO")
    private int memberNo;

    @Column(name="CREATE_DATE")
    @CreationTimestamp
    private java.util.Date createDate;

    @Column(name="IMAGE_URL")
    private String imageURL;
}
