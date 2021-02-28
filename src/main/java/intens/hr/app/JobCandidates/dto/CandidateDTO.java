package intens.hr.app.JobCandidates.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import intens.hr.app.JobCandidates.entity.Candidate;
import intens.hr.app.JobCandidates.entity.Skill;

public class CandidateDTO {
	
	private Integer id;
	private String fullName;
	private Date birthdate;
	private String contactNumber;
	private String email;
	private Set<SkillDTO> skills;
	
	
	public CandidateDTO() {
		
	}
	
	public CandidateDTO(Candidate candidate) {
		this(candidate.getId(), candidate.getFullName(), candidate.getBirthdate(), candidate.getContactNumber(),
				candidate.getEmail(), getSkillsDTO(candidate.getSkills()));
	}

	public CandidateDTO(Integer id, String fullName, Date birthdate, String contactNumber, String email, Set<SkillDTO> skills) {
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

	public Set<SkillDTO> getSkills() {
		return skills;
	}

	public void setSkills(Set<SkillDTO> skills) {
		this.skills = skills;
	}

	public static Set<SkillDTO> getSkillsDTO(Set<Skill> skills){
		Set<SkillDTO> skillsDTO=new HashSet<>();
		for(Skill skill : skills) {
			skillsDTO.add(new SkillDTO(skill));
		}
		return skillsDTO;
	}
	
}
