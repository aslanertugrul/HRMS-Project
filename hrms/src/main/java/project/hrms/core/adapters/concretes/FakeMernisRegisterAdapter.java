package project.hrms.core.adapters.concretes;

import org.springframework.stereotype.Service;

import project.hrms.core.adapters.abstracts.FakeCandidateMernisService;
import project.hrms.entities.concretes.Candidate;

@Service
public class FakeMernisRegisterAdapter implements FakeCandidateMernisService{

	@Override
	public boolean checkEntryPerson(Candidate candidate) {
		return true;
	}

}
