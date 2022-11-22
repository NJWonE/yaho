package com.noh.yaho.meeting.query.dto;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MeetingInfoDTO {
    private int meetingNo;
    private java.util.Date meetingStartTime;
}
