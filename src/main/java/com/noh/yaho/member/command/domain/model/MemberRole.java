package com.noh.yaho.member.command.domain.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="TBL_MEMBER_ROLE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@IdClass(MemberRolePK.class)
public class MemberRole {

    @Id
    @Column(name="MEMBER_NO")
    private int memberNo;

    @Id
    @ManyToOne
    @JoinColumn(name="AUTHORITY_NO")
    private MemberAuthority authorityNo;
}
