package intens.hr.app.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import intens.hr.app.JobCandidates.entity.Skill;
import intens.hr.app.JobCandidates.repository.SkillRepository;
import intens.hr.app.JobCandidates.service.SkillService;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class SkillServiceTest {

	@MockBean
	SkillRepository skillRepository;
	
	@InjectMocks
	SkillService skillService;
	
	@Test
	public void testCheckUniqueDuplicateName() {
		Integer id = null;
		String name = "C++";
		
		Skill skill = new Skill(1,name);
		Mockito.when(skillRepository.findByName(name)).thenReturn(skill);
		
		String result = skillService.checkUnique(id, name);
		
		assertEquals(result, "DuplicatedName");
	}
}
