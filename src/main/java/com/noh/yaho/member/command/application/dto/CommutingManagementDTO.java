package com.noh.yaho.member.command.application.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CommutingManagementDTO {

    private int commutingManagementNo;

    private java.util.Date attendanceTime;

    private java.util.Date leaveTime;

    private int memberNo;
}
