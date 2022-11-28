package com.noh.yaho.project.command.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="TBL_PROJECT")
@SequenceGenerator(
        name = "PROJECT_SEQUENCE",
        sequenceName = "SEQ_PROJECT_SEQUENCE",
        initialValue = 1,
        allocationSize = 1
)
@Getter
@Setter
@ToString
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROJECT_SEQUENCE")
    @Column(name="PROJECT_NO")
    private int projectNo;

    @Column(name="PROJECT_NAME", length = 100)
    private String projectName;

    @Column(name="PROJECT_SUBJECT", length = 100)
    private String projectSubject;

    @Embedded
    private ProjectPeriod projectPeriod;

    @Column(name="IS_PROCESS", length = 1)
    private String isProcess = "Y";

    @OneToMany
    @JoinColumn(name="PROJECT_NO")
    private List<ProjectMember> projectMemberLists;

    public Project() {
    }

    public Project(String projectName, String projectSubject, ProjectPeriod projectPeriod) {
        this.projectName = projectName;
        this.projectSubject = projectSubject;
        this.projectPeriod = projectPeriod;
    }
}
