package project.hrms.core.adapters.abstracts;

import project.hrms.entities.concretes.Candidate;

public interface MernisCheckService {
	public boolean checkIfRealPerson(Candidate candidate);
}
