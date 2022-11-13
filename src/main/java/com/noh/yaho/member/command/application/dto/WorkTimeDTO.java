package com.noh.yaho.member.command.application.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WorkTimeDTO {

    private int commutingManagementNo;
    private java.util.Date workStartTime;
    private java.util.Date workEndTime;
}
