package com.noh.yaho.project.command.application.service;

import com.noh.yaho.project.command.application.dto.ProjectDTO;
import com.noh.yaho.project.command.domain.model.Project;
import com.noh.yaho.project.command.domain.model.ProjectPeriod;
import com.noh.yaho.project.command.domain.repository.ProjectRepository;
import com.noh.yaho.project.command.domain.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class ProjectRegistService {
    ProjectRepository projectRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public ProjectRegistService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Transactional
    public Integer registProject(ProjectDTO projectDTO){

        Project newProject = new Project(projectDTO.getProjectName(),
                projectDTO.getProjectSubject(),
                projectDTO.getRepresentativeMemberNo(),
                new ProjectPeriod(projectDTO.getStartDate(), projectDTO.getEndDate()),
                projectDTO.getProjectMemberList());
        projectRepository.save(newProject);
        return newProject.getProjectNo();
    }
}
