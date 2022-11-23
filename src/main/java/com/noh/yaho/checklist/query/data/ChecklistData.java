package com.noh.yaho.checklist.query.data;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TBL_CHECKLIST")
public class ChecklistData {

    @Column(name="CHECKLIST_NO")
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
}
