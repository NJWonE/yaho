package com.noh.yaho.member.command.domain.model;


import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberRolePK implements Serializable {

    private int memberNo;

    private int authorityNo;
}
