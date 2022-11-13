package com.noh.yaho.member.command.application.service;

import com.noh.yaho.member.command.domain.model.Member;
import com.noh.yaho.member.command.domain.repository.MemberRepository;
import com.noh.yaho.member.dto.Authorities;
import com.noh.yaho.member.command.application.dto.MemberDTOO;
import com.noh.yaho.member.query.data.MemberData;
import com.noh.yaho.member.query.repository.MemberDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

/**
 * <pre>
 * Class : Sample
 * Comment : 어떤 클래스인지 간단한 설명
 * History
 * 2022-10-26 노재원 처음 작성
 * </pre>
 *
 * @author 노재원(최초 작성자 명)
 * @version 1.0(클래스의 버전)
 * @see 참고할 class나 외부 url
 */
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberDataRepository memberDataRepository;
    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
        Optional<MemberData> findMember = memberDataRepository.findByMemberId(memberId);
        MemberData member = findMember.get();
        if(member==null){
            throw new UsernameNotFoundException("아이디가 없음");
        }
        return member;
    }
}
