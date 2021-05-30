package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Job;
import project.hrms.entities.concretes.JobField;

public interface JobFieldService {

	DataResult<List<JobField>> getAll();
	Result add(JobField jobField);
	Result update(JobField jobField);
	DataResult<List<JobField>> getByTitle(String title);
}
