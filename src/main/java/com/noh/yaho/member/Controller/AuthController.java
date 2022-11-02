package com.noh.yaho.member.Controller;

import com.noh.yaho.common.ResponseDTO;
import com.noh.yaho.member.dto.Authorities;
import com.noh.yaho.member.dto.MemberDTO;
import com.noh.yaho.member.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

//    @PostMapping("/signup")
//    public ResponseEntity<ResponseDto> signup(@RequestBody MemberDto memberDto) {
//
//        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.CREATED, "회원가입 성공", authService.signup(memberDto)));
//    }


    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login() {
        Map<String, String> map = new HashMap<>();
        map.put("memberId", "test02");
        map.put("memberPw", "pass02");
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "로그인 성공", authService.login(map)));
    }
}
