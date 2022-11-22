package com.noh.yaho.meeting.command.application.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MeetingDTO {
    private int projectNo;
    private List<ConversationDTO> conversation;
}
