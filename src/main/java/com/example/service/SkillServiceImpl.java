package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.SkillDao;
import com.example.entity.Skill;

@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
	SkillDao skillDao;
	
	@Override
	public Skill addSkill(Skill skill) {
		Skill s= skillDao.save(skill);
		return s;
	}

	@Override
	public List<Skill> getAllSkills() {
		List<Skill> skillList = skillDao.findAll();
		return skillList;
	}

}
