package com.noh.yaho.member.command.application.controller;

import com.noh.yaho.common.dto.ResponseDTO;
import com.noh.yaho.member.command.application.dto.MemberDTO;
import com.noh.yaho.member.query.service.MemberDuplicateService;
import com.noh.yaho.member.command.application.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberCommandController {
    private final MemberService memberService;


    @PostMapping
    public ResponseDTO registMember(@Validated @RequestBody MemberDTO memberDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<String> errors = bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
            return new ResponseDTO(HttpStatus.BAD_REQUEST, "입력한 정보가 올바르지 않습니다.", errors);
        }
        return new ResponseDTO(HttpStatus.OK, "회원가입성공", memberService.registMember(memberDTO));
    }



    @PostMapping("/login")
    public ResponseDTO login(@RequestBody MemberDTO memberDTO){
        return new ResponseDTO(HttpStatus.OK, "회원로그인성공/토큰발급", memberService.login(memberDTO));
    }
}
