package com.noh.yaho.checklist.command.application.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ChecklistDTO {
    private String title;
    private String isChecked;
    private int memberNo;
    private int checklistNo;
}
