package com.noh.yaho.member.command.application.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CheckFaceDTO {
    private String faceType;
    private MultipartFile image;
}
