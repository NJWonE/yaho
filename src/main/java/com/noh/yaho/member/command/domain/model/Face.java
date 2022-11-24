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

    @Column(name="FRONT")
    private String front;

    @Column(name="LEFT")
    private String left;

    @Column(name="RIGHT")
    private String right;

    public Face(int memberNo, String front, String left, String right) {
        this.memberNo = memberNo;
        this.front = front;
        this.left = left;
        this.right = right;
    }
}
