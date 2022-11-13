package com.noh.yaho.member.command.domain.repository;

import com.noh.yaho.member.command.domain.model.CommutingManagement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommutingManagementRepository extends JpaRepository<CommutingManagement, Integer> {
}
