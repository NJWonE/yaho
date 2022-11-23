package com.noh.yaho.checklist.query.repository;

import com.noh.yaho.checklist.query.data.ChecklistData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ChecklistDataRepository extends JpaRepository<ChecklistData, Integer> {
    public List<ChecklistData> findByMemberNoAndCreateDateBetween(int memberNo, Date startDate, Date endDate);
}
