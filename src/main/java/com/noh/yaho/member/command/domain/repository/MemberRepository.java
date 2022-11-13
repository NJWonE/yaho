package com.noh.yaho.member.command.domain.repository;

import com.noh.yaho.member.command.domain.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findByMemberId(String memberId);
    boolean existsByMemberId(String MemberId);
}
