package com.noh.yaho.member.command.domain.repository;

import com.noh.yaho.member.command.domain.model.Face;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaceRepository extends JpaRepository<Face, Integer> {
}
