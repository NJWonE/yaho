package com.noh.yaho.meeting.command.application.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MeetingResultDTO {
    private String record;
    private List<String> summary;
    private String graph;
    private List<String> keyword;
}
