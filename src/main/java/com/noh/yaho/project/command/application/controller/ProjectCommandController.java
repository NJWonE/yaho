package com.noh.yaho.project.command.application.controller;

import com.noh.yaho.common.dto.ResponseDTO;
import com.noh.yaho.project.command.application.dto.ProjectDTO;
import com.noh.yaho.project.command.application.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Tag(name="PROJECT", description = "PROJECT 생성, 조회 API")
@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectCommandController {

    private final ProjectService projectService;

    @Operation(description = "프로젝트 생성 하기 위해 필요한 값을 전달 받는다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @Parameters({
            @Parameter(name ="projectName", description = "프로젝트 이름", example = "1분기 프로젝트"),
            @Parameter(name ="projectSubject", description = "프로젝트 주제", example = "시장조사를 통한 고도화 작업"),
            @Parameter(name = "startDate", description = "프로젝트 시작 날짜", example = "2022-11-10"),
            @Parameter(name = "endDate", description = "프로젝트 종료 날짜", example = "2022-12-01"),
            @Parameter(name = "projectMemberList", description = "프로젝트 구성 멤버 넘버목록", example = "[1,2,3,4,5]")
    })
    @PostMapping
    public ResponseDTO registProject(@RequestBody ProjectDTO projectDTO){
        return new ResponseDTO(HttpStatus.OK, "프로젝트 생성 성공", projectService.registProject(projectDTO));
    }
}
