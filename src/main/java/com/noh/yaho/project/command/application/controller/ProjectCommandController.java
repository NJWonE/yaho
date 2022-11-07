package com.noh.yaho.project.command.application.controller;

import com.noh.yaho.common.dto.ResponseDTO;
import com.noh.yaho.project.command.application.dto.ProjectDTO;
import com.noh.yaho.project.command.application.service.ProjectRegistService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectCommandController {

    private final ProjectRegistService projectRegistService;

    @PostMapping
    public ResponseDTO registProject(@RequestBody ProjectDTO projectDTO){
        System.out.println("projectDTO = " + projectDTO);
        return new ResponseDTO(HttpStatus.OK, "프로젝트 생성 성공", projectRegistService.registProject(projectDTO));
    }

}
