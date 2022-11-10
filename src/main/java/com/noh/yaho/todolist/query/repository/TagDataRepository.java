package com.noh.yaho.todolist.query.repository;

import com.noh.yaho.todolist.query.data.TagData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagDataRepository extends JpaRepository<TagData, Integer> {
}
