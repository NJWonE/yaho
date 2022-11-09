package com.noh.yaho.todolist.query.data;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_TAG")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TagData {
    @Id
    @Column(name="TAG_NO")
    private int tagNo;

    @Column(name="TAG_NAME")
    private String tagName;
}
