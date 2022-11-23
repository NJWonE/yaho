package com.noh.yaho.checklist.command.domain.repository;

import com.noh.yaho.checklist.command.domain.model.DailyGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyGraphRepository extends JpaRepository<DailyGraph, Integer> {
}
