package com.noh.yaho.meeting.command.application.service;

import com.noh.yaho.meeting.command.application.dto.ConversationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MeetingService {
    public List<ConversationDTO> registMeeting(List<ConversationDTO> conversationDTOList) {
        conversationDTOList.sort(new Comparator<ConversationDTO>() {
            @Override
            public int compare(ConversationDTO o1, ConversationDTO o2) {
                if(o1.getTime().getTime()-o2.getTime().getTime()>1){
                    return 1;
                }else{
                    return -1;
                }
            }
        });
        return conversationDTOList;
    }
}
