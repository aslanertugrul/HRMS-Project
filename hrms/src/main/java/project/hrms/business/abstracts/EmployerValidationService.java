package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Candidate;
import project.hrms.entities.concretes.Employer;

public interface EmployerValidationService {

	Result validate(Employer employer);	
	
}
