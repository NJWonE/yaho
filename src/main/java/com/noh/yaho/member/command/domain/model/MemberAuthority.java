package com.noh.yaho.member.command.domain.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="TBL_MEMBER_AUTHORITY")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class MemberAuthority {

    @Id
    @Column(name="AUTHORITY_NO")
    private int AuthorityNo;

    @Column(name="AUTHORITY_NAME")
    private String authorityName;
}
