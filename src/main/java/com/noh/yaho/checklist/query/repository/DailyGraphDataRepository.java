package com.noh.yaho.checklist.query.repository;

import com.noh.yaho.checklist.query.data.DailyGraphData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface DailyGraphDataRepository extends JpaRepository<DailyGraphData, Integer> {
    public Optional<DailyGraphData> findByMemberNoAndCreateDateBetween(int MemberNo, Date startDate, Date endDate);
}
