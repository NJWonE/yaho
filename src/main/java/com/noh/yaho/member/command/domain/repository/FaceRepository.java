package com.noh.yaho.member.command.domain.repository;

import com.noh.yaho.member.command.domain.model.Face;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@EnableJpaRepositories
public interface FaceRepository extends JpaRepository<Face, Integer> {
    public Optional<Face> findByMemberNo(int memberNo);
}
