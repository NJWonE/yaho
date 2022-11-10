package com.noh.yaho.member.query.data;

import com.noh.yaho.member.command.domain.model.AddressVO;
import com.noh.yaho.member.command.domain.model.MemberRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="TBL_MEMBER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberData {

    @Id
    @Column(name="MEMBER_NO")
    private int memberNo;

    @Column(name="MEMBER_ID")
    private String memberId;
    @Column(name="MEMBER_PW")
    private String memberPw;

    @Column(name = "name")
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

}
