package intens.hr.app.JobCandidates.convert;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import intens.hr.app.JobCandidates.dto.CandidateDTO;
import intens.hr.app.JobCandidates.entity.Candidate;

@Component
public class CandidateDTOtoCandidate implements Converter<CandidateDTO, Candidate> {

	@Override
	public Candidate convert(CandidateDTO source) {
		if(source == null) {
			return null;
		}
		Candidate candidate = new Candidate();
		candidate.setId(source.getId());
		if(source.getFullName()!=null) {
			candidate.setFullName(source.getFullName());
		}
		if(source.getBirthdate()!=null) {
			candidate.setBirthdate(source.getBirthdate());
		}
		if(source.getContactNumber()!=null) {
			candidate.setContactNumber(source.getContactNumber());
		}
		if(source.getEmail()!=null) {
			candidate.setEmail(source.getEmail());
		}
		return candidate;
	}

	
}
