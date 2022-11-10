package com.noh.yaho.member.command.domain.repository;

import com.noh.yaho.member.command.domain.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    boolean existsByMemberId(String MemberId);
}
