package com.noh.yaho.checklist.query.repository;

import com.noh.yaho.checklist.query.data.ChecklistData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ChecklistDataRepository extends JpaRepository<ChecklistData, Integer> {
    public List<ChecklistData> findByMemberNoAndProjectNoAndCreateDateBetween(int memberNo, int projectNo, Date startDate, Date endDate);
}
