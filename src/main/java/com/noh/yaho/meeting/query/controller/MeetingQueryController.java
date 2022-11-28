package com.noh.yaho.meeting.query.controller;

import com.noh.yaho.common.dto.ResponseDTO;
import com.noh.yaho.meeting.query.dto.MeetingResultDTO;
import com.noh.yaho.meeting.query.service.MeetingQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/meetings")
public class MeetingQueryController {
    private final MeetingQueryService meetingQueryService;

//    @GetMapping("/emergency")
//    public ResponseDTO selectMeetings(){
//        MeetingResultDTO meetingResultDTO = new MeetingResultDTO();
//
//        return new ResponseDTO(HttpStatus.OK, "조회성공",);
//    }

    @GetMapping("/{meetingNo}")
    public ResponseDTO selectMeeting(@PathVariable("meetingNo") int meetingNo){
        return new ResponseDTO(HttpStatus.OK, "미팅 내용 조회성공", meetingQueryService.selectMeeting(meetingNo));
    }

    @GetMapping
    public ResponseDTO selectMeetingByProjectNo(@RequestParam(name="projectNo")int projectNo){
        return new ResponseDTO(HttpStatus.OK, "프로젝트별 미팅 목록 조회 성공", meetingQueryService.selectMeetingByProjectNo(projectNo));
    }
}
