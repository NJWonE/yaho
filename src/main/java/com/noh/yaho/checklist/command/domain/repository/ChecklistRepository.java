package com.noh.yaho.checklist.command.domain.repository;

import com.noh.yaho.checklist.command.domain.model.Checklist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ChecklistRepository extends JpaRepository<Checklist, Integer> {
    public List<Checklist> findByMemberNoAndCreateDateBetween(int memberNo, Date startDate, Date endDate);
}

