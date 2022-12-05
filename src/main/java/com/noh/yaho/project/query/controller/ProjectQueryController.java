package com.noh.yaho.project.query.controller;


import com.noh.yaho.common.dto.ResponseDTO;
import com.noh.yaho.project.query.service.ProjectQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name="PROJECT")
@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectQueryController {

    private final ProjectQueryService projectQueryService;

    @Operation(description = "해당 멤버의 프로젝트 목록을 조회한다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @Parameters({
            @Parameter(name = "memberNo", description = "멤버번호", example = "1"),
            @Parameter(name = "isProcess", description = "프로젝트 진행 여부", example = "Y")
    })
    @GetMapping
    public ResponseDTO selectProjectByMemberNo(@RequestParam(name = "memberNo", required = false)int memberNo,@RequestParam(name ="isProcess")String isProcess){
        return new ResponseDTO(HttpStatus.OK, "멤버별 프로젝트 조회 성공", projectQueryService.selectProjectByMemberNo(memberNo, isProcess));
    }
    @Operation(description = "프로젝트의 정보를 조회한다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @Parameters({
            @Parameter(name = "projectNo", description = "프로젝트번호", example = "1"),
    })
    @GetMapping("/{projectNo}")
    public ResponseDTO selectProject(@PathVariable("projectNo") int projectNo){
        return new ResponseDTO(HttpStatus.OK, "프로젝트조회성공", projectQueryService.selectProject(projectNo));
    }

}
