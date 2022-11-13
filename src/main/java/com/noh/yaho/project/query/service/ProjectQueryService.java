package com.noh.yaho.project.query.service;

import com.noh.yaho.project.command.domain.model.Project;
import com.noh.yaho.project.query.data.ProjectMemberData;
import com.noh.yaho.project.query.repository.ProjectMemberDataRepository;
import com.noh.yaho.project.query.repository.ProjectDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectQueryService {
    private final ProjectDataRepository projectDataRepository;
    private final ProjectMemberDataRepository projectMemberDataRepository;

    public Optional<Project> selectProject(int projectNo){
        return projectDataRepository.findById(projectNo);
    }

    public List<Project> selectProjectByMemberNo(int memberNo, String isProcess) {
        List<ProjectMemberData> projectMemberDataList = projectMemberDataRepository.findByMemberNo(memberNo);

        List<Integer> projectNoList = new ArrayList<>();
        for (int i=0; i<projectMemberDataList.size(); i++){
            projectNoList.add(projectMemberDataList.get(i).getProjectNo());
        }

        return projectDataRepository.findByProjectNoInAndIsProcess(projectNoList, isProcess);
    }
}
