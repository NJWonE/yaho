package com.noh.yaho.project.query.controller;


import com.noh.yaho.common.dto.ResponseDTO;
import com.noh.yaho.project.query.service.ProjectQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectQueryController {

    private final ProjectQueryService projectQueryService;

    @GetMapping
    public ResponseDTO selectProjectByMemberNo(@RequestParam(name = "memberNo", required = false)int memberNo,@RequestParam(name ="isProcess")String isProcess){
        return new ResponseDTO(HttpStatus.OK, "멤버별 프로젝트 조회 성공", projectQueryService.selectProjectByMemberNo(memberNo, isProcess));
    }

    @GetMapping("/{projectNo}")
    public ResponseDTO selectProject(@PathVariable("projectNo") int projectNo){
        return new ResponseDTO(HttpStatus.OK, "프로젝트조회성공", projectQueryService.selectProject(projectNo));
    }

}
