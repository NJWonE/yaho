package com.noh.yaho.member.command.application.controller;

import com.noh.yaho.common.dto.ResponseDTO;
import com.noh.yaho.member.command.application.dto.WorkTimeDTO;
import com.noh.yaho.member.command.application.service.WorkTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workTime")
@RequiredArgsConstructor
public class WorkTimeController {

    private final WorkTimeService workTimeService;

    @PostMapping
    public ResponseDTO registWorkTime(@RequestBody WorkTimeDTO workTimeDTO){
        return new ResponseDTO(HttpStatus.OK, "업무시간 등록 성공", workTimeService.registWorkTime(workTimeDTO));
    }
}
