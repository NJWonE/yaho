package com.noh.yaho.member.query.service;

import com.noh.yaho.member.query.data.WorkTimeData;
import com.noh.yaho.member.query.repository.WorkTimeDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkTimeQueryService {

    private final WorkTimeDataRepository workTimeDataRepository;
    public WorkTimeData selectWorkTime(int memberNo) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c1 = Calendar.getInstance();

        String strToday = sdf.format(c1.getTime());
        Date startDateTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(strToday + " 00:00:00");
        Date endDateTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(strToday + " 23:59:59");
        List<WorkTimeData> workTimeDataList = workTimeDataRepository.findByMemberNoAndWorkStartTimeBetween(memberNo,startDateTime,endDateTime);
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
