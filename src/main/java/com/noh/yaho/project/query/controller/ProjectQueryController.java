package com.noh.yaho.project.query.controller;


import com.noh.yaho.common.dto.ResponseDTO;
import com.noh.yaho.project.query.repository.ProjectQueryRepository;
import com.noh.yaho.project.query.service.ProjectSelectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectQueryController {

    private final ProjectSelectService projectSelectService;

    @GetMapping
    public ResponseDTO selectProjectByMemberNo(@RequestParam(name = "memberNo", required = false)int memberNo,@RequestParam(name ="isProcess")String isProcess){
        return new ResponseDTO(HttpStatus.OK, "멤버별 프로젝트 조회 성공", projectSelectService.selectProjectByMemberNo(memberNo, isProcess));
    }

    @GetMapping("/{projectNo}")
    public ResponseDTO selectProject(@PathVariable("projectNo") int projectNo){
        return new ResponseDTO(HttpStatus.OK, "프로젝트조회성공", projectSelectService.selectProject(projectNo));
    }

}
