package com.noh.yaho.member.query.service;

import com.noh.yaho.member.query.data.CommutingManagementData;
import com.noh.yaho.member.query.data.WorkTimeData;
import com.noh.yaho.member.query.dto.FindWorkTimeDataDTO;
import com.noh.yaho.member.query.repository.CommutingManagementDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommutingManagementQueryService {
    private final CommutingManagementDataRepository commutingManagementDataRepository;
    public int selectCommutingManagementNo(int memberNo) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c1 = Calendar.getInstance();

        String strToday = sdf.format(c1.getTime());
        Date startDateTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(strToday+" 00:00:00");
        Date endDateTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(strToday+" 23:59:59");
        List<CommutingManagementData> commutingManagementDataList = commutingManagementDataRepository.findByMemberNoAndAttendanceTimeBetween(memberNo, startDateTime, endDateTime);
        if(commutingManagementDataList==null){
            throw new NullPointerException("출근 정보가 없습니다.");
        }
        return commutingManagementDataList.get(0).getCommutingManagementNo();
    }

    public List<WorkTimeData> selectWorkTime(FindWorkTimeDataDTO findWorkTimeDataDTO) {
        List<CommutingManagementData> commutingManagementDataList = commutingManagementDataRepository.findByMemberNoAndAttendanceTimeBetween(findWorkTimeDataDTO.getMemberNo(), findWorkTimeDataDTO.getStartDate(),findWorkTimeDataDTO.getEndDate());
        List<WorkTimeData> workTimeDataList = new ArrayList<>();
        for(int i=0; i<commutingManagementDataList.size(); i++){
            for(int j=0; j<commutingManagementDataList.get(i).getWorkTimeList().size(); j++){
                workTimeDataList.add(commutingManagementDataList.get(i).getWorkTimeList().get(j));
            }
        }
        return workTimeDataList;
    }
}
