package com.noh.yaho.checklist.query.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FindChecklistDTO {
    private int memberNo;
    private java.util.Date startDate;
    private java.util.Date endDate;

    public FindChecklistDTO(int memberNo) {
        this.memberNo = memberNo;
    }
}
