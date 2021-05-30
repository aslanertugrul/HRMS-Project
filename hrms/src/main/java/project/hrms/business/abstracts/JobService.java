package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Job;
import project.hrms.entities.concretes.JobField;
import project.hrms.entities.dto.ActiveJobDto;


public interface JobService {
	
	DataResult<List<Job>> getAll();
	Result add(Job job);
	Result addForEmployers(Job job , int jobField);
	Result update(Job job);
	Result makePassive(int jobId , int employerId);
	DataResult<List<ActiveJobDto>> getByJobStatus(boolean status);
	DataResult<List<ActiveJobDto>> findAllByJobStatusOrderByJobPublishDateDesc(boolean status);
	DataResult<List<ActiveJobDto>> getByJobStatusAndJobOwnerId(boolean status , int id);
	
}
