package com.noh.yaho.member.query.repository;

import com.noh.yaho.member.query.data.CommutingManagementData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CommutingManagementDataRepository extends JpaRepository<CommutingManagementData, Integer> {
    public List<CommutingManagementData> findByMemberNoAndAttendanceTimeBetween(int memberNo, Date start, Date end);
}
