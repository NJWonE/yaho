package com.noh.yaho.member.command.application.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CheckFaceResultDTO {
    private String faceType;
    private List<Float> embd;
}
