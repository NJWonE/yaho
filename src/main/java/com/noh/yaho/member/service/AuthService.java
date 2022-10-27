package com.noh.yaho.member.service;

import com.noh.yaho.jwt.TokenProvider;
import com.noh.yaho.jwt.dto.TokenDTO;
import com.noh.yaho.member.dto.MemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

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
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    public AuthService(PasswordEncoder passwordEncoder, TokenProvider tokenProvider) {
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
    }
    @Transactional
    public TokenDTO login(Map<String,String> map) {

        // 1. 아이디 조회
//        MemberDto member = memberMapper.findByMemberId(memberDto.getMemberId())
//                .orElseThrow(() -> new LoginFailedException("잘못된 아이디 또는 비밀번호입니다"));
        MemberDTO member = new MemberDTO();
        // 2. 비밀번호 매칭
        if (!passwordEncoder.matches(map.get("memberPw"), member.getPassword())) {
        }
        // 3. 토큰 발급
        TokenDTO tokenDto = tokenProvider.generateTokenDTO(member);
        return tokenDto;
    }
}
