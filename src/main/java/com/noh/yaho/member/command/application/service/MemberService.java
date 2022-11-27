package com.noh.yaho.member.command.application.service;

import com.noh.yaho.configuration.jwt.TokenProvider;
import com.noh.yaho.configuration.jwt.dto.TokenDTO;
import com.noh.yaho.member.command.application.dto.CheckFaceDTO;
import com.noh.yaho.member.command.application.dto.CheckFaceResultDTO;
import com.noh.yaho.member.command.application.dto.MemberDTO;
import com.noh.yaho.member.command.domain.model.AddressVO;
import com.noh.yaho.member.command.domain.model.Face;
import com.noh.yaho.member.command.domain.model.Member;
import com.noh.yaho.member.command.domain.model.MemberRole;
import com.noh.yaho.member.command.domain.repository.FaceRepository;
import com.noh.yaho.member.command.domain.repository.MemberAuthorityRepository;
import com.noh.yaho.member.command.domain.repository.MemberRepository;
import com.noh.yaho.member.command.domain.repository.MemberRoleRepository;
import com.noh.yaho.member.command.domain.service.MemberAiConnectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberRoleRepository memberRoleRepository;
    private final MemberAuthorityRepository memberAuthorityRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    private final FaceRepository faceRepository;

    @Transactional
    public Integer registMember(MemberDTO memberDTO) {
        Member newMember = new Member(memberDTO.getMemberId(), passwordEncoder.encode(memberDTO.getMemberPw()), memberDTO.getName(), memberDTO.getPhone(), memberDTO.getEmail(), new AddressVO(memberDTO.getAddress()));
        memberRepository.save(newMember);
        MemberRole newMemberRole = new MemberRole(newMember.getMemberNo(), memberAuthorityRepository.findById(1).get());
        memberRoleRepository.save(newMemberRole);
//        Face newFace = new Face(newMember.getMemberNo(), memberDTO.getFace().get("front"), memberDTO.getFace().get("left"), memberDTO.getFace().get("right"));
//        faceRepository.save(newFace);
        return newMember.getMemberNo();
    }

    public TokenDTO login(MemberDTO memberDTO) {
        Member member = memberRepository.findByMemberId(memberDTO.getMemberId()).orElseThrow(()->new NullPointerException("아이디가 없습니다"));
        if(!passwordEncoder.matches(memberDTO.getMemberPw(), member.getMemberPw())){
            throw new RuntimeException("비밀번호 오류");
        }
        return tokenProvider.generateTokenDTO(member);
    }


}
