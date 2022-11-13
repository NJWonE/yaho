package com.noh.yaho.member.query.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FindWorkTimeDataDTO {
    private int memberNo;
    private java.util.Date startDate;
    private java.util.Date endDate;
}
