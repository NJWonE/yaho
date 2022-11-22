package com.noh.yaho.meeting.query.data;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="TBL_MEETING")
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MeetingData {

    @Id
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

}
