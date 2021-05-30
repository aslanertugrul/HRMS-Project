package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import project.hrms.business.abstracts.EmployerService;
import project.hrms.business.abstracts.EmployerValidationService;
import project.hrms.core.adapters.abstracts.EmailSendService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.EmployerDao;
import project.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {


	private EmailSendService emailService;
	private EmployerDao employerDao;
	private EmployerValidationService employerValidationService;

	@Autowired
	public EmployerManager(EmailSendService emailService, EmployerDao employerDao,
			EmployerValidationService employerValidationService) {
		super();
		this.emailService = emailService;
		this.employerDao = employerDao;
		this.employerValidationService = employerValidationService;
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "iş verenler listelendi");
	}

	@Override
	public Result add(Employer employer) {

		if (employerValidationService.validate(employer) instanceof SuccessResult) {
			Result result =  employerValidationService.validate(employer);
			this.employerDao.save(employer);
			//this.emailSendService.sendEmail(employer);
			return result;
			}
		return employerValidationService.validate(employer);
	}

	
}
