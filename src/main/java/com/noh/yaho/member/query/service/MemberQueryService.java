package com.noh.yaho.member.query.service;

import com.noh.yaho.member.command.application.dto.MemberDTO;
import com.noh.yaho.member.command.domain.model.Member;
import com.noh.yaho.member.query.data.MemberData;
import com.noh.yaho.member.query.dto.MemberDataDTO;
import com.noh.yaho.member.query.repository.MemberDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberQueryService {
    private final MemberDataRepository memberDataRepository;
    @Transactional
    public List<MemberDataDTO> selectMember(String name) {
        List<MemberData> memberList = memberDataRepository.findByName(name);
        List<MemberDataDTO> memberDtoList = new ArrayList<>();
        for (int i = 0; i < memberList.size(); i++) {
            memberDtoList.add(new MemberDataDTO(memberList.get(i).getMemberNo(), memberList.get(i).getMemberId(),
                    memberList.get(i).getName()));
        }
        return memberDtoList;
    }
    @Transactional
    public MemberDataDTO selectLoginMember(int memberNo) {
        MemberData memberData = memberDataRepository.findById(memberNo).get();
        MemberDataDTO memberDataDTO = new MemberDataDTO(memberData.getMemberNo(), memberData.getMemberId(), memberData.getName());
        return memberDataDTO;
    }
    @Transactional
    public List<String> selectMemberName(List<Integer> memberNoList) {
        List<String> memberNameList = new ArrayList<>();
        List<MemberData> memberDataList = memberDataRepository.findByMemberNoIn(memberNoList);
        memberDataList.forEach(memberData -> memberNameList.add(memberData.getName()));
        return memberNameList;
    }
}
