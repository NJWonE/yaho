package com.noh.yaho.checklist.query.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FindChecklistDTO {
    private int memberNo;
    private int projectNo;
    private java.util.Date startDate;
    private java.util.Date endDate;

    public FindChecklistDTO(int memberNo, int projectNo) {
        this.memberNo = memberNo;
        this.projectNo = projectNo;
    }
}
