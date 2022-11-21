package com.noh.yaho.meeting.command.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="TBL_MEETING")
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SequenceGenerator(
        name="MEETING_SEQUENCE",
        sequenceName = "SEQ_MEETING_SEQUENCE",
        initialValue = 1,
        allocationSize = 1
)
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="MEETING_SEQUENCE")
    @Column(name="MEETING_NO")
    private int meetingNo;

    @Column(name="PROJECT_NO")
    private int projectNo;

    @Column(name="IMAGE_URL")
    private String imageURL;

    @Column(name="SUMMARY")
    @ElementCollection
    @CollectionTable(
            name="SUMMARY",
            joinColumns = @JoinColumn(name="MEETING_NO")
    )
    private List<String> summary;

    @Column(name="RECORD")
    @Lob
    private String record;

    @Column(name="KEYWORD")
    @ElementCollection
    @CollectionTable(
            name="KEYWORD",
            joinColumns = @JoinColumn(name="MEETING_NO")
    )
    private List<String> keyword;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="MEETING_START_TIME")
    private java.util.Date meetingStartTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="MEETING_END_TIME")
    private java.util.Date meetingEndTime;

    public Meeting(int projectNo, String imageURL, List<String> summary, String record, List<String> keyword, Date meetingStartTime, Date meetingEndTime) {
        this.projectNo = projectNo;
        this.imageURL = imageURL;
        this.summary = summary;
        this.record = record;
        this.keyword = keyword;
        this.meetingStartTime = meetingStartTime;
        this.meetingEndTime = meetingEndTime;
    }
}
