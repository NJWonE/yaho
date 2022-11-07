package com.noh.yaho.project.query.repository;

import com.noh.yaho.project.command.domain.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProjectQueryRepository extends JpaRepository<Project, Integer>{
    List<Project> findByProjectNoInAndIsProcess(List<Integer> projectNo, String isProcess);
}
