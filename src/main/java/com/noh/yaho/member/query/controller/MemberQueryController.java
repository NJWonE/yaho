package com.noh.yaho.member.query.controller;


import com.noh.yaho.common.dto.ResponseDTO;
import com.noh.yaho.member.query.service.MemberDuplicateService;
import com.noh.yaho.member.query.service.MemberQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "MEMBER")
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberQueryController {

    private final MemberQueryService memberQueryService;
    private final MemberDuplicateService memberDuplicateService;

    @Operation(description = "이름으로 멤버 찾기")
    @Parameters({
            @Parameter(name = "name", description = "멤버 이름", example = "노재원")
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping("/{name}")
    public ResponseDTO selectMember(@PathVariable String name){
        return new ResponseDTO(HttpStatus.OK, "회원조회성공", memberQueryService.selectMember(name));
    }
    @Operation(description = "회원 번호로 회원정보 조회")
    @Parameters({
            @Parameter(name = "memberNo", description = "멤버 번호", example = "1")
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping("/auth/{memberNo}")
    public ResponseDTO selectLoginMember(@PathVariable int memberNo){
        return new ResponseDTO(HttpStatus.OK, "단일회원정보조회성공", memberQueryService.selectLoginMember(memberNo));
    }
    @Operation(description = "멤버 아이디 중복검사")
    @Parameters({
            @Parameter(name = "memberId", description = "멤버 아이디", example = "nohjaewon123")
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping("/checkId/{memberId}")
    public ResponseDTO checkMemberId(@PathVariable String memberId){
        return new ResponseDTO(HttpStatus.OK, "아이디중복검사결과", memberDuplicateService.checkMemberId(memberId));
    }

    @Operation(description = "회원 이름 검색")
    @Parameters({
            @Parameter(name = "memberId", description = "멤버 아이디", example = "nohjaewon123")
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping("/name/{memberNoList}")
    public ResponseDTO selectMemberName(@PathVariable List<Integer> memberNoList){
        return new ResponseDTO(HttpStatus.OK, "회원 이름 목록 조회 성공", memberQueryService.selectMemberName(memberNoList));
    }
}
