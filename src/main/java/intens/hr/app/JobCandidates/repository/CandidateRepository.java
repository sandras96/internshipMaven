package intens.hr.app.JobCandidates.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import intens.hr.app.JobCandidates.entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

	List<Candidate> findByFullNameContaining(String name);
	Candidate findByEmail(String email);
	
	@Query(value = "SELECT DISTINCT c.* FROM candidate c JOIN candidate_skill cs ON c.candidate_id = cs.candidate_id JOIN skill s ON cs.skill_id = s.skill_id WHERE s.name like ?;",nativeQuery = true)
	List<Candidate> findBySkillName(String skill);
}
