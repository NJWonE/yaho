package com.noh.yaho.member.query.controller;


import com.noh.yaho.common.dto.ResponseDTO;
import com.noh.yaho.member.query.service.MemberDuplicateService;
import com.noh.yaho.member.query.service.MemberQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberQueryController {

    private final MemberQueryService memberQueryService;
    private final MemberDuplicateService memberDuplicateService;

    @GetMapping("/{name}")
    public ResponseDTO selectMember(@PathVariable String name){
        return new ResponseDTO(HttpStatus.OK, "회원조회성공", memberQueryService.selectMember(name));
    }

    @GetMapping("/auth/{memberNo}")
    public ResponseDTO selectLoginMember(@PathVariable int memberNo){
        return new ResponseDTO(HttpStatus.OK, "단일회원정보조회성공", memberQueryService.selectLoginMember(memberNo));
    }
    @GetMapping("/checkId/{memberId}")
    public ResponseDTO checkMemberId(@PathVariable String memberId){
        return new ResponseDTO(HttpStatus.OK, "아이디중복검사결과", memberDuplicateService.checkMemberId(memberId));
    }

    @GetMapping("/name/{memberNoList}")
    public ResponseDTO selectMemberName(@PathVariable List<Integer> memberNoList){
        return new ResponseDTO(HttpStatus.OK, "회원 이름 목록 조회 성공", memberQueryService.selectMemberName(memberNoList));
    }
}
