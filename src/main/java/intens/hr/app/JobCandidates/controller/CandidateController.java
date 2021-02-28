package intens.hr.app.JobCandidates.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import intens.hr.app.JobCandidates.convert.CandidateDTOtoCandidate;
import intens.hr.app.JobCandidates.convert.CandidateToCandidateDTO;
import intens.hr.app.JobCandidates.dto.CandidateDTO;
import intens.hr.app.JobCandidates.entity.Candidate;
import intens.hr.app.JobCandidates.entity.Skill;
import intens.hr.app.JobCandidates.service.CandidateService;
import intens.hr.app.JobCandidates.service.SkillService;

@RestController
@RequestMapping(value="api/candidates")
@CrossOrigin(origins = "http://localhost:4200")
public class CandidateController {
	
	@Autowired
	CandidateService candidateService;
	
	@Autowired
	SkillService skillService;
	
	@Autowired
	CandidateDTOtoCandidate candidateDTOtoCandidate;
	
	@Autowired
	CandidateToCandidateDTO candidateToCandidateDTO;
	
	
	@RequestMapping(value="/all",  method= RequestMethod.GET)
	public ResponseEntity<List<CandidateDTO>> getAllCandidates(){
		List<Candidate> candidates = candidateService.findAll();
		List<CandidateDTO> candidatesDTO = new ArrayList<CandidateDTO>();
		for(Candidate candidate : candidates) {
				candidatesDTO.add(new CandidateDTO(candidate));
		}
		return new ResponseEntity<>(candidatesDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<CandidateDTO> getCandidateById(@PathVariable("id") Integer id){
		Candidate candidate = candidateService.findOne(id);
		if(candidate == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new CandidateDTO(candidate), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<CandidateDTO> createCandidate(@RequestBody CandidateDTO candidateDTO){
		Candidate candidate = candidateService.save(candidateDTOtoCandidate.convert(candidateDTO));
		
		return new ResponseEntity<>(candidateToCandidateDTO.convert(candidate), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<CandidateDTO> deleteCandidate(@PathVariable("id") Integer id){
		Candidate candidate = candidateService.findOne(id);
		if(candidate == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			candidateService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json", value="/{id}")
	public ResponseEntity<CandidateDTO> addSkillToCandidate(@RequestBody List<Skill> skills, @PathVariable("id") Integer id){
		System.out.println("Update candidate " + skills);
		Candidate candidate = candidateService.findOne(id);
		if(candidate== null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		for(Skill s : skills) {
			candidate.addSkill(s);
		}
		candidateService.save(candidate);

		return new ResponseEntity<>(candidateToCandidateDTO.convert(candidate), HttpStatus.OK);
	}
	@RequestMapping(value="/deleteSkill/{cId}/{sId}",method=RequestMethod.DELETE)
	public ResponseEntity<CandidateDTO> deleteSkillFromCandidate(@PathVariable("cId") Integer cId, @PathVariable("sId") Integer sId){
		Skill skill = skillService.findOne(sId);
		Candidate candidate = candidateService.findOne(cId);
		if(candidate== null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Set<Skill> skills = candidate.getSkills();
		skills.remove(skill);
		candidate.setSkills(skills);
		skill.getCandidates().remove(candidate);
		
		candidateService.save(candidate);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/searchByName/{name}")
	public ResponseEntity<List<CandidateDTO>> searchByName(@PathVariable("name") String name) throws Exception {
		System.out.println("Search by name: " + name);
		List<CandidateDTO> candidatesDTO = new ArrayList<CandidateDTO>();
		List<Candidate> candidates = new ArrayList<Candidate>();
		candidates = candidateService.getAllByName(name);
		for(Candidate candidate : candidates) {
				candidatesDTO.add(new CandidateDTO(candidate));
		}
		return new ResponseEntity<List<CandidateDTO>>(candidatesDTO,HttpStatus.OK);
	}

	@RequestMapping(value="/searchBySkill/{skill}")
	public ResponseEntity<List<CandidateDTO>> searchBySkill(@PathVariable("skill") String skill) throws Exception {
		String s = "%"+skill+"%";
		List<CandidateDTO> candidatesDTO = new ArrayList<CandidateDTO>();
		List<Candidate> candidates = new ArrayList<Candidate>();
		candidates = candidateService.getAllBySkill(s);
		for(Candidate candidate : candidates) {
				candidatesDTO.add(new CandidateDTO(candidate));
		}
		return new ResponseEntity<List<CandidateDTO>>(candidatesDTO,HttpStatus.OK);
	}
	
}
