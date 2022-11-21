package com.noh.yaho.meeting.query.repository;

import com.noh.yaho.meeting.query.data.MeetingData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Transactional(readOnly=true)
public interface MeetingDataRepository extends JpaRepository<MeetingData, Integer> {
    public List<MeetingData> findByProjectNo(int projectNo);
}
