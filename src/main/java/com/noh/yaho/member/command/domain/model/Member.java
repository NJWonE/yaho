package com.noh.yaho.member.command.domain.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

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
@Entity
@Table(name="TBL_MEMBER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@SequenceGenerator(
        name="MEMBER_SEQUENCE",
        sequenceName = "SEQ_MEMBER_SEQUENCE",
        initialValue = 1,
        allocationSize = 1
)
public class Member implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQUENCE")
    @Column(name="MEMBER_NO")
    private int memberNo;

    @Column(name="MEMBER_ID")
    private String memberId;
    @Column(name="MEMBER_PW")
    private String memberPw;

    @Column(name="NAME")
    private String name;

    @Column(name="PHONE")
    private String phone;

    @Column(name="EMAIL")
    private String email;

    @Embedded
    private AddressVO address;

    @OneToMany
    @JoinColumn(name="MEMBER_NO")
    private List<MemberRole> memberAuthorities;

    public Member(String memberId, String memberPw, String name, String phone, String email, AddressVO address) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for(int i=0; i<memberAuthorities.size(); i++){
            list.add(new SimpleGrantedAuthority(memberAuthorities.get(i).getAuthorityNo().getAuthorityName()));
        }
        return list;
    }

    @Override
    public String getPassword() {
        return this.memberPw;
    }

    @Override
    public String getUsername() {
        return this.memberId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}