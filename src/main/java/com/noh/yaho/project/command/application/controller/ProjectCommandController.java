package com.noh.yaho.project.command.application.controller;

import com.noh.yaho.common.dto.ResponseDTO;
import com.noh.yaho.project.command.application.dto.ProjectDTO;
import com.noh.yaho.project.command.application.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectCommandController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseDTO registProject(@RequestBody ProjectDTO projectDTO){
        System.out.println("projectDTO = " + projectDTO);
        return new ResponseDTO(HttpStatus.OK, "프로젝트 생성 성공", projectService.registProject(projectDTO));
    }

}
