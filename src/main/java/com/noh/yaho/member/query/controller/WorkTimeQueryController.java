package com.noh.yaho.member.query.controller;

import com.noh.yaho.common.dto.ResponseDTO;
import com.noh.yaho.member.query.service.WorkTimeQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/workTime")
public class WorkTimeQueryController {

    private final WorkTimeQueryService workTimeQueryService;

    @GetMapping
    public ResponseDTO selectWorkTime(@RequestParam("commutingManagementNo")int commutingManagementNo){
        return new ResponseDTO(HttpStatus.OK, "업무집중시간 조회 성공", workTimeQueryService.selectWorkTime(commutingManagementNo));
    }
}
