package com.noh.yaho.checklist.command.application.service;

import com.noh.yaho.checklist.command.application.dto.ChecklistDTO;
import com.noh.yaho.checklist.command.domain.model.Checklist;
import com.noh.yaho.checklist.command.domain.repository.ChecklistRepository;
import com.noh.yaho.checklist.query.data.ChecklistData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ChecklistService {

    private final ChecklistRepository checklistRepository;

    @Transactional
    public int registChecklist(ChecklistDTO checkListDTO) {
        Checklist newChecklist = new Checklist(checkListDTO.getTitle(), checkListDTO.getMemberNo(), checkListDTO.getIsChecked());
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
}
