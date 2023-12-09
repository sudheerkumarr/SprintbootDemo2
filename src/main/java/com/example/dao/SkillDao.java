package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Skill;

@Repository
public interface SkillDao extends JpaRepository<Skill, Integer> {
	@Query(value="select skill.skill_name from employee join employee_skills on employee.emp_id=employee_skills.emp_id join skill on skill.skill_id=employee_skills.skill_id where employee.emp_id=:id", nativeQuery=true)
	List<String> getSkillByEmpId(@Param("id") int empId);
}
