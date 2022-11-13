package com.noh.yaho.member.query.controller;

import com.noh.yaho.common.dto.ResponseDTO;
import com.noh.yaho.member.query.service.CommutingManagementQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/commutingManagement")
@RequiredArgsConstructor
public class CommutingManagementQueryController {

    private final CommutingManagementQueryService commutingManagementQueryService;

    @GetMapping("/{memberNo}")
    public ResponseDTO selectCommutingManagementNo(@PathVariable("memberNo") int memberNo) throws ParseException {
        return new ResponseDTO(HttpStatus.OK, "출근관리넘버조회성공", commutingManagementQueryService.selectCommutingManagementNo(memberNo));
    }
}
