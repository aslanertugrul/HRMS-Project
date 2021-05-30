package project.hrms.business.abstracts;

import project.hrms.business.concretes.constMessages;
import project.hrms.core.utilities.results.ErrorResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.entities.concretes.Candidate;
import project.hrms.entities.concretes.Employer;

public interface CandidateValidationService {
 
	Result validate(Candidate candidate);	
}
