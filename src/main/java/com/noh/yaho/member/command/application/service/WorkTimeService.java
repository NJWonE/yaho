package com.noh.yaho.member.command.application.service;

import com.noh.yaho.member.command.application.dto.WorkTimeDTO;
import com.noh.yaho.member.command.domain.model.WorkTime;
import com.noh.yaho.member.command.domain.repository.CommutingManagementRepository;
import com.noh.yaho.member.command.domain.repository.WorkTimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkTimeService {

    private final WorkTimeRepository workTimeRepository;
    private final CommutingManagementRepository commutingManagementRepository;
    public int registWorkTime(WorkTimeDTO workTimeDTO) {
        List<WorkTime> workTimeList = commutingManagementRepository.findById(workTimeDTO.getCommutingManagementNo()).get().getWorkTimeList();
        if(workTimeList.isEmpty()){
            new RuntimeException("출근기록이 없습니다.");
        }
        WorkTime newWorkTime = new WorkTime(workTimeDTO.getWorkStartTime(), workTimeDTO.getWorkEndTime());
        workTimeRepository.save(newWorkTime);
        workTimeList.add(newWorkTime);
        return newWorkTime.getWorkTimeNo();
    }
}
