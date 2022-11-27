package com.noh.yaho.member.command.domain.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="TBL_FACE")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(
        name="FACE_SEQUENCE",
        sequenceName = "SEQ_FACE_SEQUENCE",
        initialValue = 1,
        allocationSize = 1
)
public class Face {
    @Id
    @Column(name="FACE_NO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FACE_SEQUENCE")
    private int faceNo;

    @Column(name="MEMBER_NO")
    private int memberNo;

    @Column(name="FRONT_FACE")
    @Lob
    private String frontFace;

    @Column(name="LEFT_FACE")
    @Lob
    private String leftFace;

    @Column(name="RIGHT_FACE")
    @Lob
    private String rightFace;

    public Face(int memberNo, String frontFace, String leftFace, String rightFace) {
        this.memberNo = memberNo;
        this.frontFace = frontFace;
        this.leftFace = leftFace;
        this.rightFace = rightFace;
    }
}
