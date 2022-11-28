package com.noh.yaho.meeting.command.domain.service;

import com.noh.yaho.meeting.command.application.dto.ConversationDTO;
import com.noh.yaho.meeting.query.dto.MeetingResultDTO;
import org.springframework.util.MultiValueMap;

import java.util.List;

public interface MeetingAiConnectionService {

    public MeetingResultDTO request(MultiValueMap<String, List<ConversationDTO>> body, String aiURL);
}
