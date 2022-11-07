package com.noh.yaho.project.command.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
public class ProjectPeriod {

    @Column(name="START_DATE")
    private java.util.Date startDate;

    @Column(name="END_DATE")
    private java.util.Date endDate;

    public ProjectPeriod() {
    }

    public ProjectPeriod(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
