package intens.hr.app.JobCandidates.dto;

import intens.hr.app.JobCandidates.entity.Skill;

public class SkillDTO {
	
	private Integer id;
	private String name;
	
	public SkillDTO() {
		
	}

	public SkillDTO(Skill skill) {
		this(skill.getId(), skill.getName());
	}
	
	public SkillDTO(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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

}
