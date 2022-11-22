package com.noh.yaho.meeting.command.application.service;

import com.noh.yaho.meeting.command.application.dto.ConversationDTO;
import com.noh.yaho.meeting.command.application.dto.MeetingDTO;
import com.noh.yaho.meeting.command.application.dto.MeetingResultDTO;
import com.noh.yaho.meeting.command.domain.model.Meeting;
import com.noh.yaho.meeting.command.domain.repository.MeetingRepository;
import com.noh.yaho.meeting.command.domain.service.AiConnectionService;
import com.noh.yaho.meeting.command.domain.service.AwsSimpleStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class    MeetingService {

    private final AiConnectionService aiConnectionService;
    private final AwsSimpleStorageService awsSimpleStorageService;
    private final MeetingRepository meetingRepository;

    public int registMeeting(MeetingDTO meetingDTO) {
        List<ConversationDTO> conversationDTOList = meetingDTO.getConversation();
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
        MultiValueMap<String, List<ConversationDTO>> body = new LinkedMultiValueMap<>();
        body.add("conversation", conversationDTOList);

        String aiURL = "http://34.64.197.102:9090/meeting";

        MeetingResultDTO meetingResultDTO = aiConnectionService.request(body, aiURL);
        String imageURL = awsSimpleStorageService.upload(meetingResultDTO.getGraph());
        Meeting newMeeting = new Meeting(meetingDTO.getProjectNo(), imageURL,
                meetingResultDTO.getSummary(),
                meetingResultDTO.getRecord(),
                meetingResultDTO.getKeyword(),
                conversationDTOList.get(0).getTime(),
                conversationDTOList.get(conversationDTOList.size()-1).getTime());
        meetingRepository.save(newMeeting);

        return newMeeting.getMeetingNo();
    }
}
