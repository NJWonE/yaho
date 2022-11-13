package com.noh.yaho.member.query.data;

import com.noh.yaho.member.command.domain.model.AddressVO;
import com.noh.yaho.member.command.domain.model.MemberRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="TBL_MEMBER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberData implements UserDetails {

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

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="MEMBER_NO")
    private List<MemberRole> memberAuthorities;


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

