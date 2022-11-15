package com.noh.yaho.meeting.command.application.controller;

import com.noh.yaho.meeting.command.application.service.MeetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/meeting")
public class MeetingCommandController {
    private final MeetingService meetingService;

}
