package com.noh.yaho.checklist.query.service;

import com.noh.yaho.checklist.query.data.ChecklistData;
import com.noh.yaho.checklist.query.data.DailyGraphData;
import com.noh.yaho.checklist.query.dto.ChecklistResultDTO;
import com.noh.yaho.checklist.query.dto.FindChecklistDTO;
import com.noh.yaho.checklist.query.repository.ChecklistDataRepository;
import com.noh.yaho.checklist.query.repository.DailyGraphDataRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChecklistQueryService {

    private final ChecklistDataRepository checklistDataRepository;
    private final DailyGraphDataRepository dailyGraphDataRepository;
    public List<ChecklistResultDTO> selectChecklist(@NotNull FindChecklistDTO findChecklistDTO) throws ParseException {
        if(findChecklistDTO.getStartDate()==null){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            Calendar c1 = Calendar.getInstance();

            String strToday = format.format(c1.getTime());
            Date startDateTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(strToday+" 00:00:00");
            Date endDateTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(strToday+" 23:59:59");
            List<ChecklistData> checklistDataList = checklistDataRepository.findByMemberNoAndProjectNoAndCreateDateBetween(findChecklistDTO.getMemberNo(), findChecklistDTO.getProjectNo(), startDateTime, endDateTime);
            return checklistDataList.stream().map(checklist -> new ChecklistResultDTO(checklist.getTitle(), checklist.getChecklistNo(), checklist.getIsChecked())).collect(Collectors.toList());
        }else{
            List<ChecklistData> checklistDataList = checklistDataRepository.findByMemberNoAndProjectNoAndCreateDateBetween(findChecklistDTO.getMemberNo(), findChecklistDTO.getProjectNo(), findChecklistDTO.getStartDate(), findChecklistDTO.getEndDate());
            return checklistDataList.stream().map(checklist -> new ChecklistResultDTO(checklist.getTitle(), checklist.getChecklistNo(), checklist.getIsChecked())).collect(Collectors.toList());
        }
    }

    public String selectDailyGraph(int memberNo, Date createDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String today = sdf.format(createDate);
        Date startDateTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(today+" 00:00:00");
        Date endDateTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(today+" 23:59:59");
        DailyGraphData dailyGraphData = dailyGraphDataRepository.findByMemberNoAndCreateDateBetween(memberNo, startDateTime, endDateTime).get();
        return dailyGraphData.getImageURL();
    }
}
