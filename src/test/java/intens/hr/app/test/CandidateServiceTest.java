package intens.hr.app.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import intens.hr.app.JobCandidates.entity.Candidate;
import intens.hr.app.JobCandidates.repository.CandidateRepository;
import intens.hr.app.JobCandidates.service.CandidateService;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class CandidateServiceTest {
	
	@MockBean
	CandidateRepository candidateRepository;
	
	@InjectMocks
	CandidateService candidateService;
	
	@Test
	public void shouldReturnFalseWhenEmailIsUnique() 
	{
		Integer candidateId = null;
		String candidateEmail = "sandra@gmail.com";
		
		Mockito.when(candidateRepository.findByEmail(candidateEmail)).thenReturn(null);
		
		boolean result = candidateService.isUniqueEmail(candidateId, candidateEmail);
		
		assertFalse(result);
				
				
	}
	
	@Test
	public void shouldReturnTrueWhenEmailIsNotUnique() 
	{
		Integer candidateId = null;
		String candidateEmail = "sandra@gmail.com";
		
		Candidate candidate = new Candidate(1,"Sandra", new Date(1996-04-17), "22365", candidateEmail);
		
		Mockito.when(candidateRepository.findByEmail(candidateEmail)).thenReturn(candidate);
		
		boolean result = candidateService.isUniqueEmail(candidateId, candidateEmail);
		
		assertTrue(result);
				
				
	}

}
