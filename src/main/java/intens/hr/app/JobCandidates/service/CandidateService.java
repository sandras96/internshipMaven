package intens.hr.app.JobCandidates.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import intens.hr.app.JobCandidates.entity.Candidate;
import intens.hr.app.JobCandidates.repository.CandidateRepository;

@Service
public class CandidateService {
	
	@Autowired
	CandidateRepository candidateRepository;
	
	public Candidate findOne(Integer id) {
		return candidateRepository.findById(id).orElse(null);
	}
	
	public List<Candidate> findAll(){
		return candidateRepository.findAll();
	}
	
	public Candidate save(Candidate candidate) {
		return candidateRepository.save(candidate);
	}
	
	public void remove(Integer id) {
		candidateRepository.deleteById(id);
	}
	
	public List<Candidate> getAllByName(String name){
		return candidateRepository.findByFullNameContaining(name);
	}
	
	public List<Candidate> getAllBySkill(String skill){
		return candidateRepository.findBySkillName(skill);
	}

}
