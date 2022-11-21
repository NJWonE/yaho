package com.noh.yaho.meeting.command.application.controller;

import com.noh.yaho.common.dto.ResponseDTO;
import com.noh.yaho.meeting.command.application.dto.ConversationDTO;
import com.noh.yaho.meeting.command.application.dto.MeetingDTO;
import com.noh.yaho.meeting.command.application.service.MeetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/meetings")
public class MeetingCommandController {
    private final MeetingService meetingService;

    @PostMapping
    public ResponseDTO registMeeting(@RequestBody MeetingDTO meetingDTO){
        System.out.println("meetingDTO = " + meetingDTO);
        return new ResponseDTO(HttpStatus.OK, "미팅정보저장성공", meetingService.registMeeting(meetingDTO));
    }
}