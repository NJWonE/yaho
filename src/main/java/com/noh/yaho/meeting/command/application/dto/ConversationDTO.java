package com.noh.yaho.meeting.command.application.dto;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ConversationDTO {
    private String name;
    private String data;
    private java.util.Date time;
}
