package com.noh.yaho.project.command.domain.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="TBL_PROJECT_MEMBER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@IdClass(ProjectMemberPK.class)
public class ProjectMember {
    @Id
    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Id
    @Column(name = "PROJECT_NO")
    private int projectNo;
}
