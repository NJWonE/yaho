package com.noh.yaho.member.query.repository;

import com.noh.yaho.member.query.data.CommutingManagementData;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

public interface CommutingManagementDataRepository extends JpaRepository<CommutingManagementData, Integer> {
    public List<CommutingManagementData> findByMemberNoAndAttendanceTimeBetween(int memberNo, Date start, Date end);
}
