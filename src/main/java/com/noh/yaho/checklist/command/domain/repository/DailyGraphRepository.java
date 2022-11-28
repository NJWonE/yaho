package com.noh.yaho.checklist.command.domain.repository;

import com.noh.yaho.checklist.command.domain.model.DailyGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface DailyGraphRepository extends JpaRepository<DailyGraph, Integer> {
    public Optional<DailyGraph> findByMemberNoAndProjectNoAndCreateDateBetween(int memberNo, int projectNo, Date startDateTime, Date endDateTime);
}
