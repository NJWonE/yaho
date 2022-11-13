package com.noh.yaho.member.command.domain.repository;

import com.noh.yaho.member.command.domain.model.WorkTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkTimeRepository extends JpaRepository<WorkTime, Integer> {
}
