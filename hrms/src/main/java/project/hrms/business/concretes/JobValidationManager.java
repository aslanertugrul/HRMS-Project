package project.hrms.business.concretes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.apache.axis.types.Entities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.JobValidationService;
import project.hrms.core.utilities.results.ErrorResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.EmployerDao;
import project.hrms.dataAccess.abstracts.JobDao;
import project.hrms.dataAccess.abstracts.JobFieldDao;
import project.hrms.entities.concretes.Employer;
import project.hrms.entities.concretes.Job;
import project.hrms.entities.concretes.JobField;

@Service
public class JobValidationManager implements JobValidationService {

	private JobDao jobDao;
	private JobFieldDao jobFieldDao;
	private EmployerDao employerDao;
	
	@Autowired
	public JobValidationManager(JobDao jobDao, JobFieldDao jobFieldDao, EmployerDao employerDao) {
		super();
		this.jobDao = jobDao;
		this.jobFieldDao = jobFieldDao;
		this.employerDao = employerDao;
	}

	@Override
	public Result validate(Job job) {
		
		if (!JobOwnerIsExist(job))
			return new ErrorResult(constMessages.jobOwnerIsNtExist);
		return new SuccessResult(constMessages.jobTitleAdded);
	} 
	
	@Override
	public Result validate(JobField jobField) {
		if (!jobFieldIsExist(jobField.getTitle()))
			return new ErrorResult(constMessages.jobTitleIsExist);
		return new SuccessResult(constMessages.jobFieldAdded);
	}

	
	@Override
	public Result validateForEmployerRegister(Job job , int jobField) {
		
		
		if (!JobOwnerIsExist(job))
			return new ErrorResult(constMessages.jobOwnerIsNtExist);
		else if (jobFieldCheck(jobField))
			return new ErrorResult(constMessages.jobFieldIsNotExistForAdding);
		else if (jobDetailIsExist(job))
			return new ErrorResult(constMessages.jobDetailIsExist);
		else if (JobDetailIsEmpty(job))
			return new ErrorResult(constMessages.jobDetailIsEmpty);
		else if (!JobLocationIsOk(job))
			return new ErrorResult(constMessages.jobLocationIsOk);
		else if (!JobSalaryCheck(job))
			return new ErrorResult(constMessages.jobSalaryIsOk);
		else if (!JobQuotaCheck(job))
			return new ErrorResult(constMessages.jobQuotaIsOk);
		return new SuccessResult(constMessages.jobTitleAdded);
	}

	
	private boolean jobFieldIsExist (String field) {
		var jobFieldList=jobFieldDao.findAll();
		
		for ( JobField check : jobFieldList) {
			if (check.getTitle().equals(field))
					return false;
		}
		return true;
	}
	
	private boolean jobFieldCheck (int fieldId) {
		var jobFieldList=jobFieldDao.findAll();
		
		for ( JobField check : jobFieldList) {
			if (check.getId()==fieldId)
					return false;
		}
		return true;
	}
	
	private boolean jobDetailIsExist (Job job) {
		var jobList=jobDao.findAll();
		
		for ( Job check : jobList) {
			if (check.getJobDetail().equals(job.getJobDetail()));
					return true;
		}
		return false;
	}
	
	private boolean JobOwnerIsExist (Job job) {
		var employerList=employerDao.findAll();
		
		for ( Employer check : employerList) {
			if (check.getUserId()==(job.getJobOwnerId()))
					return true;
		}
		return false;
	}
	
	private boolean JobLocationIsOk (Job job) {
		return true;		
	}
	
	private boolean JobSalaryCheck (Job job) {
		if ((job.getJobMinSalary()==0) || (job.getJobMaxSalary()==0) || (job.getJobMaxSalary()<=job.getJobMinSalary()))
			return false;
		return true;	
	}

	private boolean JobQuotaCheck (Job job) {
		if (job.getJobQuota()==0)
			return false;
		return true;		
	}
	
	private boolean JobDetailIsEmpty (Job job) {
		if (job.getJobDetail().length()==0 || job.getJobDetail()==null)
			return true;
		return false;		
	}
	
}
