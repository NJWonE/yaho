package com.noh.yaho.member.command.application.service;

import com.noh.yaho.member.command.application.dto.CommutingManagementDTO;
import com.noh.yaho.member.command.domain.model.CommutingManagement;
import com.noh.yaho.member.command.domain.repository.CommutingManagementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommutingManagementService {

    private final CommutingManagementRepository commutingManagementRepository;
    @Transactional
    public int registCommutingManagement(CommutingManagementDTO commutingManagementDTO) {
        CommutingManagement newCommutingManagement = new CommutingManagement(commutingManagementDTO.getMemberNo());
        commutingManagementRepository.save(newCommutingManagement);
        return newCommutingManagement.getCommutingManagementNo();
    }
    @Transactional
    public int updateCommutingManagement(CommutingManagementDTO commutingManagementDTO) {
        CommutingManagement updataCommutingManagement = commutingManagementRepository.findById(commutingManagementDTO.getCommutingManagementNo()).orElseThrow(()->new RuntimeException("에러"));
        updataCommutingManagement.setLeaveTime(commutingManagementDTO.getLeaveTime());
        commutingManagementRepository.save(updataCommutingManagement);
        return updataCommutingManagement.getCommutingManagementNo();
    }
}
