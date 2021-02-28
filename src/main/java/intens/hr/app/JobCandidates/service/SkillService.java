package intens.hr.app.JobCandidates.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import intens.hr.app.JobCandidates.entity.Skill;
import intens.hr.app.JobCandidates.repository.SkillRepository;

@Service
public class SkillService {
	
	@Autowired
	SkillRepository skillRepository;
	
	public Skill findOne(Integer id) {
		return skillRepository.findById(id).orElse(null);
	}
	
	public List<Skill> findAll(){
		return skillRepository.findAll();
	}
	
	public Skill save(Skill skill) {
		return skillRepository.save(skill);
	}
	
	public List<Skill> getAllByCandidate(Integer id){
		return skillRepository.findByCandidateId(id);
	}

	public String checkUnique(Integer id, String name) {
		boolean isCreatingNew = (id==null || id==0);
		
		Skill skillByName = skillRepository.findByName(name);
		
		if(isCreatingNew) {
			if(skillByName != null) {
				return "DuplicatedName";
			}
		}
		else {
			if(skillByName !=null && skillByName.getId() != id) {
				return "DuplicatedName";
			}
		}
		
		return "OK";
	}
}
