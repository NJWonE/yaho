package com.noh.yaho.member.query.service;

import com.noh.yaho.member.command.application.dto.MemberDTO;
import com.noh.yaho.member.command.domain.model.Member;
import com.noh.yaho.member.query.data.MemberData;
import com.noh.yaho.member.query.dto.MemberDataDTO;
import com.noh.yaho.member.query.repository.MemberDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberQueryService {
    private final MemberDataRepository memberDataRepository;
    public List<MemberDataDTO> selectMember(String name) {
        List<MemberData> memberList = memberDataRepository.findByName(name);
        List<MemberDataDTO> memberDtoList = new ArrayList<>();
        for (int i = 0; i < memberList.size(); i++) {
            memberDtoList.add(new MemberDataDTO(memberList.get(i).getMemberNo(), memberList.get(i).getMemberId(),
                    memberList.get(i).getName()));
        }
        return memberDtoList;
    }
    public MemberData selectLoginMember(String memberId) {
        return memberDataRepository.findByMemberId(memberId).get();
    }
}
