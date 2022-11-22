package com.noh.yaho.checklist.command.domain.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

@Entity
@Table(name="TBL_CHECKLIST")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(
        name = "CHECKLIST_SEQUENCE",
        sequenceName = "SEQ_CHECKLIST_SEQUENCE",
        initialValue = 1,
        allocationSize = 1
)
public class Checklist {
    @Column(name="CHECKLIST_NO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHECKLIST_SEQUENCE")
    @Id
    private int checklistNo;

    @Column(name="TITLE")
    private String title;

    @Column(name="MEMBER_NO")
    private int memberNo;

    @Column(name="CREATE_DATE")
    @CreationTimestamp
    private java.util.Date createDate;

    @Column(name="IS_CHECKED")
    private String isChecked = "N";

    public Checklist(String title, int memberNo, String isChecked) {
        this.title = title;
        this.memberNo = memberNo;
        this.isChecked = isChecked;
    }
}
