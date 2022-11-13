package com.noh.yaho.member.command.application.controller;

import com.noh.yaho.common.dto.ResponseDTO;
import com.noh.yaho.member.command.application.dto.CommutingManagementDTO;
import com.noh.yaho.member.command.application.service.CommutingManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/commutingManagement")
@RequiredArgsConstructor
public class CommutingManagementCommandController {

    private final CommutingManagementService commutingManagementService;

    @PostMapping
    public ResponseDTO registCommutingManagement(@RequestBody CommutingManagementDTO commutingManagementDTO){
        return new ResponseDTO(HttpStatus.OK, "출근시간등록성공", commutingManagementService.registCommutingManagement(commutingManagementDTO));
    }

    @PostMapping("/leave")
    public ResponseDTO updataCommutingManagement(@RequestBody CommutingManagementDTO commutingManagementDTO){
        commutingManagementDTO.setLeaveTime(new Date());
        return new ResponseDTO(HttpStatus.OK, "퇴근시간등록성공", commutingManagementService.updateCommutingManagement(commutingManagementDTO));
    }
}
