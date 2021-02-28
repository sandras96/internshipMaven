package intens.hr.app.JobCandidates.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="skill")
public class Skill {
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="skill_id", unique=true, nullable=false)
	private Integer id;
	
	@Column(name="name", unique=true, nullable=false)
	private String name;
	
	@ManyToMany(mappedBy="skills")
	private Set<Candidate> candidates = new HashSet<Candidate>();

	public Skill() {
		super();
	}

	public Skill(Integer id, String name, Set<Candidate> candidates) {
		super();
		this.id = id;
		this.name = name;
		this.candidates = candidates;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(Set<Candidate> candidates) {
		this.candidates = candidates;
	}
	
	
}
