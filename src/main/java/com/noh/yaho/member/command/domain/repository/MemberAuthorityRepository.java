package com.noh.yaho.member.command.domain.repository;

import com.noh.yaho.member.command.domain.model.MemberAuthority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberAuthorityRepository extends JpaRepository<MemberAuthority, Integer> {
}
