package com.noh.yaho.checklist.command.application.service;

import com.noh.yaho.checklist.command.application.dto.ChecklistDTO;
import com.noh.yaho.checklist.command.domain.model.Checklist;
import com.noh.yaho.checklist.command.domain.model.DailyGraph;
import com.noh.yaho.checklist.command.domain.repository.ChecklistRepository;
import com.noh.yaho.checklist.command.domain.repository.DailyGraphRepository;
import com.noh.yaho.checklist.command.domain.service.AiConnectionCheckService;
import com.noh.yaho.checklist.command.domain.service.CheckAwsSimpleStorageService;
import com.noh.yaho.checklist.query.data.ChecklistData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChecklistService {

    private final ChecklistRepository checklistRepository;
    private final AiConnectionCheckService aiConnectionCheckService;
    private final CheckAwsSimpleStorageService checkAwsSimpleStorageService;
    private final DailyGraphRepository dailyGraphRepository;

    @Transactional
    public int registChecklist(ChecklistDTO checkListDTO) {
        Checklist newChecklist = new Checklist(checkListDTO.getTitle(), checkListDTO.getMemberNo());
        checklistRepository.save(newChecklist);
        return newChecklist.getChecklistNo();
    }

    @Transactional
    public int updateChecklist(ChecklistDTO checklistDTO) {
        Checklist findChecklist =  checklistRepository.findById(checklistDTO.getChecklistNo()).get();
        System.out.println("findChecklist = " + findChecklist);
        findChecklist.setIsChecked("Y");
        checklistRepository.save(findChecklist);
        return findChecklist.getChecklistNo();
    }

    public int createDailyGraph(ChecklistDTO checklistDTO) throws ParseException {
        int memberNo = checklistDTO.getMemberNo();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();

        String today = sdf.format(calendar.getTime());
        Date startDateTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(today+" 00:00:00");
        Date endDateTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(today+" 23:59:59");

        List<Checklist> checklists = checklistRepository.findByMemberNoAndCreateDateBetween(memberNo, startDateTime, endDateTime);
        int totalCount = checklists.size();
        int checkCount = checklists.stream().filter(item -> item.getIsChecked().equals("Y")).collect(Collectors.toList()).size();
        MultiValueMap<String, Integer> body = new LinkedMultiValueMap<>();

        String aiURL = "http://34.64.121.28:9090/daily";
        body.add("totalCount", totalCount);
        body.add("checkCount", checkCount);
        String responseImage = aiConnectionCheckService.createDailyGraph(body, aiURL).getGraph();
        String imageURL = checkAwsSimpleStorageService.upload(responseImage);
        DailyGraph newDailyGraph = new DailyGraph(memberNo, imageURL);
        dailyGraphRepository.save(newDailyGraph);
        return newDailyGraph.getDailyGraphNo();
    }
}
