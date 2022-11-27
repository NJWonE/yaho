package com.noh.yaho.member.query.service;

import com.noh.yaho.member.query.data.WorkTimeData;
import com.noh.yaho.member.query.repository.WorkTimeDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkTimeQueryService {

    private final WorkTimeDataRepository workTimeDataRepository;
    public WorkTimeData selectWorkTime(int commutingManagementNo) {
        List<WorkTimeData> workTimeDataList = workTimeDataRepository.findByCommutingManagementNo(commutingManagementNo);
        workTimeDataList.sort(new Comparator<WorkTimeData>() {
            @Override
            public int compare(WorkTimeData o1, WorkTimeData o2) {
                if(o1.getWorkEndTime().getTime()-o1.getWorkStartTime().getTime()<o2.getWorkEndTime().getTime()-o2.getWorkStartTime().getTime()) {
                    return 1;
                }else{
                    return -1;
                }
            }
        });
        return workTimeDataList.get(0);
    }
}
