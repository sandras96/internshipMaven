package intens.hr.app.JobCandidates.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import intens.hr.app.JobCandidates.dto.SkillDTO;
import intens.hr.app.JobCandidates.entity.Skill;
import intens.hr.app.JobCandidates.service.SkillService;

@RestController
@RequestMapping(value="api/skills")
@CrossOrigin(origins = "http://localhost:4200")
public class SkillController {
	
	@Autowired
	SkillService skillService;
	
	@RequestMapping(value="/all",  method= RequestMethod.GET)
	public ResponseEntity<List<SkillDTO>> getAllSkills(){
		List<Skill> skills = skillService.findAll();
		List<SkillDTO> skillsDTO = new ArrayList<SkillDTO>();
		for(Skill skill : skills) {
				skillsDTO.add(new SkillDTO(skill));
		}
		return new ResponseEntity<>(skillsDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<SkillDTO> createSkill(@RequestBody SkillDTO skillDTO){
		Skill skill = new Skill();
		skill.setName(skillDTO.getName());		
		skillService.save(skill);
		
		return new ResponseEntity<SkillDTO>(new SkillDTO(skill), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/candidate/{candidate_id}")
	public ResponseEntity<List<SkillDTO>> getAllByCandidateId(@PathVariable("candidate_id") Integer id) throws Exception {
		List<Skill> skills = skillService.getAllByCandidate(id);
		List<SkillDTO> skillsDTO = new ArrayList<SkillDTO>();
		for(Skill skill : skills) {
				skillsDTO.add(new SkillDTO(skill));
		}
		return new ResponseEntity<>(skillsDTO, HttpStatus.OK);
	}

}
