package com.noh.yaho.project.command.domain.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProjectMemberPK implements Serializable {

    private int memberNo;

    private int projectNo;

}
