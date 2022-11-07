package com.noh.yaho.project.command.domain.repository;

import com.noh.yaho.project.command.domain.model.ProjectMember;
import com.noh.yaho.project.command.domain.model.ProjectMemberPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberPK> {
}
