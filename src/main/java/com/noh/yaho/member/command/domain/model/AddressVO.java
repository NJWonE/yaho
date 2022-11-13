package com.noh.yaho.member.command.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class AddressVO {

    @Column(name="ADDRESS")
    private String address;
}
