package com.noh.yaho.checklist.query.controller;

import com.noh.yaho.checklist.query.dto.FindChecklistDTO;
import com.noh.yaho.checklist.query.service.ChecklistQueryService;
import com.noh.yaho.common.dto.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;

@RestController
@RequiredArgsConstructor
@RequestMapping("/checklist")
public class ChecklistQueryController {

    private final ChecklistQueryService checklistQueryService;

    @GetMapping
    public ResponseDTO selectChecklist(@RequestParam(name="memberNo")int memberNo, @RequestParam(name="projectNo")int projectNo,
                                       @RequestParam(name="startDate", required = false)@DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                       @RequestParam(name="endDate", required = false)@DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) throws ParseException {
        FindChecklistDTO findChecklistDTO = new FindChecklistDTO(memberNo, projectNo, startDate, endDate);
        return new ResponseDTO(HttpStatus.OK, "체크리스트 조회성공", checklistQueryService.selectChecklist(findChecklistDTO));
    }

    @GetMapping("/dailyGraph")
    public ResponseDTO selectDailyGraph(@RequestParam(name="memberNo")int memberNo,
                                        @RequestParam(name="createDate")@DateTimeFormat(pattern = "yyyy-MM-dd") Date createDate) throws ParseException {
        return new ResponseDTO(HttpStatus.OK, "체크리스트 당일 그래프 이미지 조회 성공", checklistQueryService.selectDailyGraph(memberNo,createDate));
    }
}
