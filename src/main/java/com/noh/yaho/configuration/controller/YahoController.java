package com.noh.yaho.configuration.controller;

import com.noh.yaho.common.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class YahoController {
    @GetMapping
    public ResponseDTO response(){
        return new ResponseDTO(HttpStatus.OK, "ㅇㅋ", new String("상태확인"));
    }
}
