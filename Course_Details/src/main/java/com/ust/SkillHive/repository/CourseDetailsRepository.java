package com.ust.SkillHive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.SkillHive.model.CourseDetails;

@Repository
public interface CourseDetailsRepository extends JpaRepository<CourseDetails, Long> {

}
