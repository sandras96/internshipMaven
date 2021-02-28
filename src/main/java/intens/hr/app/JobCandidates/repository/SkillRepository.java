package intens.hr.app.JobCandidates.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import intens.hr.app.JobCandidates.entity.Skill;

public interface SkillRepository extends JpaRepository<Skill,Integer> {
	
	Skill findByName(String name);
	
	@Query(value = "SELECT s.name FROM skill s JOIN candidate_skill cs ON s.skill_id = cs.skill_id WHERE cs.candidate_id = ?;",nativeQuery = true)
	List<Skill> findByCandidateId(Integer id);

}
