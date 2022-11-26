package com.noh.yaho.member.command.application.controller;

import com.noh.yaho.common.dto.ResponseDTO;
import com.noh.yaho.member.command.application.dto.CheckFaceDTO;
import com.noh.yaho.member.command.application.dto.DetectFaceDTO;
import com.noh.yaho.member.command.application.service.DetectFaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/detectFace")
public class DetectFaceController {

    private final DetectFaceService detectFaceService;


    @PostMapping
    @Async
    public void detectFace(@ModelAttribute DetectFaceDTO detectFaceDTO, HttpServletRequest request) throws IOException {
        HttpSession httpSession = request.getSession();
        detectFaceService.detectFace(detectFaceDTO, httpSession);
    }

    @PostMapping("/checkFace")
    public ResponseDTO checkFace(@ModelAttribute CheckFaceDTO checkFaceDTO) throws IOException {
        System.out.println("checkFaceDTO = " + checkFaceDTO);
        return new ResponseDTO(HttpStatus.OK, "테스트 통과", detectFaceService.checkFace(checkFaceDTO));
    }
}
