package com.noh.yaho.member.command.application.dto;


import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberDTO {
    @NotBlank(message = "아이디를 입력해주세요.")
    @Size(max=16, message = "아이디는 16자 이하로 입력해주세요.")
//    @Pattern(regexp = "/^[a-zA-z0-9]{3,16}$/", message = "올바른 아이디를 입력해주세요.")
    private String memberId;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Size(min = 10, max=16, message = "비밀번호는 10자 이상 16자 이하로 입력해주세요.")
//    @Pattern(regexp = "/^[a-zA-z0-9]{10,16}$/", message = "올바른 비밀번호를 입력해주세요.")
    private String memberPw;

    @NotBlank(message = "이름을 입력해주세요.")
    private String name;

    @NotBlank(message = "번호를 입력해주세요.")
//    @Pattern(regexp = "/^01[1,0,9,6]{3}-[0-9]{4}-[0-9]{4}$/", message = "올바른 번호를 입력해주세요.")
    private String phone;

    @NotBlank(message = "이메일을 입력해주세요")
    @Pattern(regexp = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "올바른 이메일을 입력해주세요.")
    private String email;

    @NotBlank(message = "주소를 입력해주세요")
    private String address;

//    @NotBlank(message = "얼굴 인식 값을 입력해주세요.")
//    @Size(min = 3, max = 3, message = "정면 오른쪽 왼쪽 얼굴 값이 다 들어와야 합니다.")
//    private Map<String, String> face;
}
