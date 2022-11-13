package com.noh.yaho.project.command.application.service;

import com.noh.yaho.project.command.application.dto.ProjectDTO;
import com.noh.yaho.project.command.domain.model.Project;
import com.noh.yaho.project.command.domain.model.ProjectMember;
import com.noh.yaho.project.command.domain.model.ProjectPeriod;
import com.noh.yaho.project.command.domain.repository.ProjectMemberRepository;
import com.noh.yaho.project.command.domain.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMemberRepository projectMemberRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Integer registProject(ProjectDTO projectDTO){
        Project newProject = new Project(projectDTO.getProjectName(),
                projectDTO.getProjectSubject(),
                projectDTO.getRepresentativeMemberNo(),
                new ProjectPeriod(projectDTO.getStartDate(), projectDTO.getEndDate()));
        projectRepository.save(newProject);

        List<ProjectMember> list = new ArrayList<>();
        // 동일한 회원번호가 리스트에 들어올 수 없다. 나중에 리팩토링
        for(int i=0; i<projectDTO.getProjectMemberList().size(); i++){
            ProjectMember newProjectMember = new ProjectMember(projectDTO.getProjectMemberList().get(i), newProject.getProjectNo());
            projectMemberRepository.save(newProjectMember);
            list.add(newProjectMember);
        }

        System.out.println("list = " + list);
        newProject.setProjectMemberLists(list);

        return newProject.getProjectNo();
    }
}
