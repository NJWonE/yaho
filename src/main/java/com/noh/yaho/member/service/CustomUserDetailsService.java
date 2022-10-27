package com.noh.yaho.member.service;

import com.noh.yaho.member.dto.Authorities;
import com.noh.yaho.member.dto.MemberDTO;
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
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberDTO memberDTO = new MemberDTO();
        if(!username.equals(memberDTO.getMemberId())){
            throw new UsernameNotFoundException("아이디가 없음");
        }
        addAuthorities(memberDTO);
        return memberDTO;
    }

    private MemberDTO addAuthorities(MemberDTO member) {
        member.setAuthorities(Arrays.asList(new SimpleGrantedAuthority(Authorities.ROLE_USER.name())));
        return member;
    }
}
