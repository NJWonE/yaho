package com.noh.yaho.project.query.data;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="TBL_PROJECT_MEMBER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@IdClass(ProjectMemberDataPK.class)
public class ProjectMemberData {

    @Id
    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Id
    @Column(name = "PROJECT_NO")
    private int projectNo;
}
