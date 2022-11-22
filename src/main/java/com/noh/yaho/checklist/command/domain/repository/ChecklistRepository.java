package com.noh.yaho.checklist.command.domain.repository;

import com.noh.yaho.checklist.command.domain.model.Checklist;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ChecklistRepository extends JpaRepository<Checklist, Integer> {
}

