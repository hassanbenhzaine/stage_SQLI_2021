package com.example.demo.dao;

import com.example.demo.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
//    List<Skill> findAllByIds(Iterable ids);
}
