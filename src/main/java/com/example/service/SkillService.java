package com.example.service;

import java.util.List;

import com.example.entity.Skill;

public interface SkillService {

	Skill addSkill(Skill skill);
	List<Skill> getAllSkills();
}
