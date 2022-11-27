package com.noh.yaho.member.command.application.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DetectFaceDTO {
    private int memberNo;
    private MultipartFile image;
}
