package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Skill;
import com.example.service.SkillService;

@RestController
public class SkillController {
	@Autowired
	SkillService skillService;
	
	// Get all skills 
	@GetMapping("/skill/all")
	List<Skill> getAllSkills() {
		return skillService.getAllSkills();
	}
	
	// add skill
	@PostMapping("/skill/add")
	Skill addSkill(Skill skill) {
		return skillService.addSkill(skill);
	}

}
