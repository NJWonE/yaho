package com.noh.yaho.todolist.command.domain.repository;

import com.noh.yaho.todolist.command.domain.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}
