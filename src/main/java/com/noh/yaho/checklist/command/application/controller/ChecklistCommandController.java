package com.noh.yaho.checklist.command.application.controller;

import com.noh.yaho.checklist.command.application.dto.ChecklistDTO;
import com.noh.yaho.checklist.command.application.service.ChecklistService;
import com.noh.yaho.common.dto.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/checklist")
@RequiredArgsConstructor
public class ChecklistCommandController {

    private final ChecklistService checkListService;

    @PostMapping
    public ResponseDTO registChecklist(@RequestBody ChecklistDTO checkListDTO){
        return new ResponseDTO(HttpStatus.OK, "체크리스트 저장성공", checkListService.registChecklist(checkListDTO));
    }

    @PutMapping
    public ResponseDTO updateChecklist(@RequestBody ChecklistDTO checklistDTO){
        return new ResponseDTO(HttpStatus.OK, "체크리스트 상태 변경 성공", checkListService.updateChecklist(checklistDTO));
    }
}
