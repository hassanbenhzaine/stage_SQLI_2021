package com.example.demo.dao;

import com.example.demo.model.HrManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HrManagerRepository extends JpaRepository<HrManager, Long> {

    List<HrManager> findAllByStatus(Boolean bool);
}
