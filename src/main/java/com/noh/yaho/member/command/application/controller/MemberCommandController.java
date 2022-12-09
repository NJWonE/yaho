package com.noh.yaho.member.command.application.controller;

import com.noh.yaho.common.dto.ResponseDTO;
import com.noh.yaho.member.command.application.dto.CheckFaceDTO;
import com.noh.yaho.member.command.application.dto.MemberDTO;
import com.noh.yaho.member.command.application.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.parameters.P;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "MEMBER", description = "MEMBER 생성, 조회, 업데이트 API")
@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberCommandController {
    private final MemberService memberService;

    @Operation(description = "회원 가입")
    @Parameters({
            @Parameter(name = "memberId", description = "멤버 아이디", example = "nohjaewon123"),
            @Parameter(name = "memberPw", description = "멤버 비밀번호", example = "123123"),
            @Parameter(name = "name", description = "멤버 이름", example = "노재원"),
            @Parameter(name = "phone", description = "핸드폰 번호", example = "010-1234-5678"),
            @Parameter(name = "email", description = "이메일", example = "nohjaewon123@naver.com"),
            @Parameter(name = "address", description = "주소", example = "서울시 강북구 삼양동"),
            @Parameter(name = "face", description = "안면 인식 캡처 값", example = "[{faceType:front, image:base64String},{faceType:left, image:base64String},{faceType:right, image:base64String}]"),
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @PostMapping
    public ResponseDTO registMember(@Validated @RequestBody MemberDTO memberDTO, BindingResult bindingResult){
        System.out.println("memberDTO.getFace().get(\"left\") = " + memberDTO.getFace().get("left"));
        if(bindingResult.hasErrors()){
            List<String> errors = bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
            return new ResponseDTO(HttpStatus.BAD_REQUEST, "입력한 정보가 올바르지 않습니다.", errors);
        }
        return new ResponseDTO(HttpStatus.OK, "회원가입성공", memberService.registMember(memberDTO));
    }
    @Operation(description = "로그인")
    @Parameters({
            @Parameter(name = "memberId", description = "멤버 아이디", example = "nohjaewon123"),
            @Parameter(name = "memberPw", description = "멤버 비밀번호", example = "123123123")
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @PostMapping("/login")
    public ResponseDTO login(@RequestBody MemberDTO memberDTO){
        return new ResponseDTO(HttpStatus.OK, "회원로그인성공/토큰발급", memberService.login(memberDTO));
    }


}
