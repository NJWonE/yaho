package com.noh.yaho.project.query.repository;

import com.noh.yaho.project.query.data.ProjectMemberDataPK;
import com.noh.yaho.project.query.data.ProjectMemberData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectMemberDataRepository extends JpaRepository<ProjectMemberData, ProjectMemberDataPK> {
    List<ProjectMemberData> findByMemberNo(int memberNo);
}
