package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.JobFieldService;
import project.hrms.business.abstracts.JobValidationService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.JobFieldDao;
import project.hrms.entities.concretes.Job;
import project.hrms.entities.concretes.JobField;

@Service
public class JobFieldManager implements JobFieldService {

	private JobValidationService jobValidationService;
	private JobFieldDao jobFieldDao;

	@Autowired
	public JobFieldManager(JobValidationService jobValidationService, JobFieldDao jobFieldDao) {
		super();
		this.jobValidationService = jobValidationService;
		this.jobFieldDao = jobFieldDao;
	}
	
	
	@Override
	public Result add(JobField jobField) {
		if (jobValidationService.validate(jobField) instanceof SuccessResult) {
			Result result =  jobValidationService.validate(jobField);
			this.jobFieldDao.save(jobField);
			return result;
			}
		return jobValidationService.validate(jobField);
	}

	@Override
	public Result update(JobField jobField) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobField>> getByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public DataResult<List<JobField>> getAll() {
		return new SuccessDataResult<List<JobField>>(this.jobFieldDao.findAll());
	}
	
	
}
