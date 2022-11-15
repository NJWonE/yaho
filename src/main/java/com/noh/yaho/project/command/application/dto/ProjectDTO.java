package com.noh.yaho.project.command.application.dto;


import lombok.Data;
import java.util.List;

@Data
public class ProjectDTO {
    private String projectName;
    private String projectSubject;
    private int representativeMemberNo;
    private java.util.Date startDate;
    private java.util.Date endDate;
    private List<Integer> projectMemberList;
}
