package com.noh.yaho.meeting.command.domain.service;

import com.noh.yaho.meeting.command.application.dto.ConversationDTO;
import com.noh.yaho.meeting.command.application.dto.MeetingResultDTO;
import org.springframework.util.MultiValueMap;

import java.util.List;

public interface AiConnectionService {

    public MeetingResultDTO request(MultiValueMap<String, List<ConversationDTO>> body, String aiURL);
}
