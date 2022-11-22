package com.noh.yaho.meeting.command.application.dto;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ConversationDTO {
    private String name;
    private String text;
    private java.util.Date time;
}
