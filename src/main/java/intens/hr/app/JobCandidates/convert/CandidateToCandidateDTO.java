package intens.hr.app.JobCandidates.convert;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import intens.hr.app.JobCandidates.dto.CandidateDTO;
import intens.hr.app.JobCandidates.entity.Candidate;

@Component
public class CandidateToCandidateDTO implements Converter<Candidate, CandidateDTO> {

	@Override
	public CandidateDTO convert(Candidate source) {
		if(source == null) {
			return null;
		}
		CandidateDTO candidateDTO = new CandidateDTO();
		candidateDTO.setId(source.getId());
		if(source.getFullName()!=null) {
			candidateDTO.setFullName(source.getFullName());
		}
		if(source.getBirthdate()!=null) {
			candidateDTO.setBirthdate(source.getBirthdate());
		}
		if(source.getContactNumber()!=null) {
			candidateDTO.setContactNumber(source.getContactNumber());
		}
		if(source.getEmail()!=null) {
			candidateDTO.setEmail(source.getEmail());
		}
		return candidateDTO;
	}


}
