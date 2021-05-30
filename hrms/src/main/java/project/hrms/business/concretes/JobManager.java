package project.hrms.business.concretes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import net.bytebuddy.asm.Advice.This;
import project.hrms.business.abstracts.JobService;
import project.hrms.business.abstracts.JobValidationService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.EmployerDao;
import project.hrms.dataAccess.abstracts.JobDao;
import project.hrms.entities.concretes.Candidate;
import project.hrms.entities.concretes.Job;
import project.hrms.entities.concretes.JobField;
import project.hrms.entities.dto.ActiveJobDto;

@Service
public class JobManager implements JobService {

	private JobDao jobDao;
	private EmployerDao employerDao;
	private JobValidationService jobValidationService;
	
	@Autowired
	public JobManager(EmployerDao employerDao,
			JobValidationService jobValidationService, JobDao jobDao) {
		super();
		this.jobDao = jobDao;
		this.employerDao = employerDao;
		this.jobValidationService = jobValidationService;
	}

	@Override
	public DataResult<List<Job>> getAll() { //Req 8 : Sistemdeki tüm aktif iş ilanları listelenebilmelidir.
		return new SuccessDataResult<List<Job>>(this.jobDao.findAll(),"İşler listelendi");
	}


	@Override
	public Result add(Job job) { // Req 3 : Sisteme genel iş pozisyonu isimleri eklenebilmelidir. Örneğin Software Developer, Software Architect
		if (jobValidationService.validate(job) instanceof SuccessResult) {
			Result result =  jobValidationService.validate(job);
			this.jobDao.save(job);
			//this.emailSendService.sendEmail(employer);
			return result;
			}
		return jobValidationService.validate(job);
	}
	
	@Override
	public Result addForEmployers( Job job, int jobField) {
		if (jobValidationService.validateForEmployerRegister(job,jobField) instanceof SuccessResult) {
			Result result =  jobValidationService.validateForEmployerRegister(job,jobField);
			this.jobDao.save(job);
			//this.emailSendService.sendEmail(employer);
			return result;
			}
		return jobValidationService.validateForEmployerRegister(job,jobField);
	}

	
	@Override
	public Result update(Job job) {
		Job updatedJob = this.jobDao.getOne(job.getJobID());
		this.jobDao.delete(updatedJob);	
		
		this.jobDao.save(job);
		return new SuccessResult("Başarıyla güncellendi.");
	}

	@Override
	public Result makePassive(int jobId , int employerId ) { // Req 11 : İş verenler sistemdeki bir ilanı kapatabilmelidir. (Pasif ilan)
		
		if (this.jobDao.getByJobID(jobId).getJobOwnerId()==employerId) {
			this.jobDao.getByJobID(jobId).setJobStatus(false);
			return new SuccessResult("İş ilanı iş veren tarafından pasif hale getirildi.");
		}
		return new ErrorResult("İş ilanınını sadece oluşturan iş veren veya sistem personeli pasif hale getirebilir.");
	}


	@Override
	public DataResult<List<ActiveJobDto>> getByJobStatus(boolean status) { // Req 8 : Sistemdeki tüm aktif iş ilanları listelenebilmelidir.
		List<Job> selectedJobs= this.jobDao.getByJobStatus(true);
		
		return new SuccessDataResult <List<ActiveJobDto>>(useDto(selectedJobs, status) , "Aktif iş ilanları listelendi");
	}
	
	@Override
	public DataResult<List<ActiveJobDto>> findAllByJobStatusOrderByJobPublishDateDesc(boolean status) { // Req 9 : Sistemdeki tüm aktif iş ilanları tarihe göre listelenebilmelidir.
		
		List<ActiveJobDto> sortedActiveJobs = this.jobDao.findAllByJobStatusOrderByCreatedDateDesc(status);
		
		return new SuccessDataResult<List<ActiveJobDto>>(sortedActiveJobs , "Aktif iş ilanları yeniden eskiye doğru sıralandı");
	}

	
	@Override
	public DataResult<List<ActiveJobDto>> getByJobStatusAndJobOwnerId(boolean status , int id) {  // Req 10 : Sistemde bir firmaya ait tüm aktif iş ilanları listelenebilmelidir.
		List<Job> selectedJobs= this.jobDao.getByJobStatusAndJobOwnerId(true ,id);
		
		return new SuccessDataResult<List<ActiveJobDto>>(useDto(selectedJobs, true) , "İşverene ait aktif iş ilanları listelendi");
	}
	
	public ArrayList<ActiveJobDto> useDto (List<Job> selectedJobs, boolean status) {
		
		ArrayList<ActiveJobDto> activeJobs = new ArrayList<ActiveJobDto>();
		
		for (Job job : selectedJobs) {
			for (ActiveJobDto activeJobsDto : activeJobs) {
				activeJobsDto.setEmployerId(job.getJobOwnerId());;
				activeJobsDto.setJobDetail(job.getJobDetail());
				activeJobsDto.setJobQuote(job.getJobQuota());
				activeJobsDto.setJobPublishDate(job.getCreatedDate()); ;
					}
			}
		return activeJobs;
	}




}
