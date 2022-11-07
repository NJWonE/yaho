package com.noh.yaho.project.query.data;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProjectMemberDataPK implements Serializable {

    private int memberNo;

    private int projectNo;

}
