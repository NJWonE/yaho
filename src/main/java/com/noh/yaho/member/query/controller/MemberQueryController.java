package com.noh.yaho.member.query.controller;


import com.noh.yaho.common.dto.ResponseDTO;
import com.noh.yaho.member.query.service.MemberDuplicateService;
import com.noh.yaho.member.query.service.MemberQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/auth/{memberId}")
    public ResponseDTO selectLoginMember(@PathVariable String memberId){
        return new ResponseDTO(HttpStatus.OK, "인증확인로그인정보조회성공", memberQueryService.selectLoginMember(memberId));
    }
    @GetMapping("/checkId/{memberId}")
    public ResponseDTO checkMemberId(@PathVariable String memberId){
        return new ResponseDTO(HttpStatus.OK, "아이디중복검사결과", memberDuplicateService.checkMemberId(memberId));
    }
}
