package com.noh.yaho.member.query.repository;

import com.noh.yaho.member.query.data.MemberData;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface MemberDataRepository extends JpaRepository <MemberData, Integer>{
    List<MemberData> findByName(String name);
    Optional<MemberData> findByMemberId(String memberId);
    boolean existsByMemberId(String MemberId);
    List<MemberData> findByMemberNoIn(List<Integer> memberNoList);
}
