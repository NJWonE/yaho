package com.noh.yaho.meeting.command.application.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MeetingResultDTO {
    private String summary;
    private String conversation;
    private String image;
}
