package com.noh.yaho.checklist.query.service;

import com.noh.yaho.checklist.query.data.ChecklistData;
import com.noh.yaho.checklist.query.dto.FindChecklistDTO;
import com.noh.yaho.checklist.query.repository.ChecklistDataRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChecklistQueryService {

    private final ChecklistDataRepository checklistDataRepository;
    public List<ChecklistData> selectChecklist(@NotNull FindChecklistDTO findChecklistDTO) throws ParseException {
        if(findChecklistDTO.getStartDate()==null){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            Calendar c1 = Calendar.getInstance();

            String strToday = format.format(c1.getTime());
            Date startDateTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(strToday+" 00:00:00");
            Date endDateTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(strToday+" 23:59:59");

            return checklistDataRepository.findByMemberNoAndCreateDateBetween(findChecklistDTO.getMemberNo(), startDateTime, endDateTime);
        }else{
            return checklistDataRepository.findByMemberNoAndCreateDateBetween(findChecklistDTO.getMemberNo(), findChecklistDTO.getStartDate(), findChecklistDTO.getEndDate());
        }
    }
}
