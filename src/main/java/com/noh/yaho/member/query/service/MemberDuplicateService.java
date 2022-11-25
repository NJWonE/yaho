package com.noh.yaho.member.query.service;

import com.noh.yaho.member.command.domain.repository.MemberRepository;
import com.noh.yaho.member.query.data.MemberData;
import com.noh.yaho.member.query.repository.MemberDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberDuplicateService {

    private final MemberDataRepository memberDataRepository;
    @Transactional
    public boolean checkMemberId(String memberId) {
        return memberDataRepository.existsByMemberId(memberId);
    }
}
