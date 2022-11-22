package com.noh.yaho.meeting.query.service;

import com.noh.yaho.meeting.query.data.MeetingData;
import com.noh.yaho.meeting.query.dto.MeetingInfoDTO;
import com.noh.yaho.meeting.query.repository.MeetingDataRepository;
import com.noh.yaho.member.query.data.MemberData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MeetingQueryService {
    private final MeetingDataRepository meetingDataRepository;

    public MeetingData selectMeeting(int meetingNo){
        return meetingDataRepository.findById(meetingNo).get();
    }

    public List<MeetingInfoDTO> selectMeetingByProjectNo(int projectNo) {
        List<MeetingData> meetingList = meetingDataRepository.findByProjectNo(projectNo);
        List<MeetingInfoDTO> meetingInfoDTOList = new ArrayList<>();
        for(int i=0; i<meetingList.size(); i++){
            MeetingInfoDTO meetingInfo = new MeetingInfoDTO(meetingList.get(i).getMeetingNo(), meetingList.get(i).getMeetingStartTime());
            meetingInfoDTOList.add(meetingInfo);
        }
        return meetingInfoDTOList;
    }
}
