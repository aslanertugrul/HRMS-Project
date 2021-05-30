package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Job;
import project.hrms.entities.concretes.JobField;

public interface JobValidationService {

	Result validateForEmployerRegister (Job job , int jobField);
	Result validate (Job job);
	Result validate (JobField job);
}
