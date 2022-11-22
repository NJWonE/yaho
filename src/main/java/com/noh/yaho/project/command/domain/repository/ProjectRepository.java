package com.noh.yaho.project.command.domain.repository;

import com.noh.yaho.project.command.domain.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProjectRepository extends JpaRepository<Project, Integer>{
}
