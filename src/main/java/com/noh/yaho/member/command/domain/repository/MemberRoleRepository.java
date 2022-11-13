package com.noh.yaho.member.command.domain.repository;

import com.noh.yaho.member.command.domain.model.MemberRole;
import com.noh.yaho.member.command.domain.model.MemberRolePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRoleRepository extends JpaRepository<MemberRole, MemberRolePK> {
}
