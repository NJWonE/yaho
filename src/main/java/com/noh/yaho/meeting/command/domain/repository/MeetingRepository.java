package com.noh.yaho.meeting.command.domain.repository;

import com.noh.yaho.meeting.command.domain.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Integer>{
}
