package intens.hr.app.JobCandidates.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="candidate")
public class Candidate {
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="candidate_id", unique=true, nullable=false)
	private Integer id;
	
	@Column(name="name", unique=false, nullable=false)
	private String fullName;
	
	@Column(name="birthdate", unique= false, nullable=false)
	private Date birthdate;
	
	@Column(name="number", unique= false, nullable=false)
	private String contactNumber;
	
	@Column(name="email", unique= true, nullable=false)
	private String email;
	
	@ManyToMany
    @JoinTable(name = "candidate_skill", 
            joinColumns = { @JoinColumn(name = "candidate_id") }, 
            inverseJoinColumns = { @JoinColumn(name = "skill_id") })
	private Set<Skill> skills = new HashSet<Skill>();

	public Candidate() {
		super();
	}

	public Candidate(Integer id, String fullName, Date birthdate, String contactNumber, String email,
			Set<Skill> skills) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.birthdate = birthdate;
		this.contactNumber = contactNumber;
		this.email = email;
		this.skills = skills;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Skill> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}
	
	public void addSkill(Skill skill) {
        this.skills.add(skill);
        skill.getCandidates().add(this);
	}
	 

}
