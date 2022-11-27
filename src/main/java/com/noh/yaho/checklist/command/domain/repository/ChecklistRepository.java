package com.noh.yaho.checklist.command.domain.repository;

import com.noh.yaho.checklist.command.domain.model.Checklist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ChecklistRepository extends JpaRepository<Checklist, Integer> {
    public List<Checklist> findByMemberNoAndProjectNoAndCreateDateBetween(int memberNo, int projectNo, Date startDate, Date endDate);
}

