package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.EmployerValidationService;

import project.hrms.core.utilities.results.ErrorResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.EmployerDao;

import project.hrms.entities.concretes.Employer;


@Service
public class EmployerValidationManager implements EmployerValidationService{

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerValidationManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public Result validate(Employer employer) {
		if (!employerTitleCheck(employer))
			return new ErrorResult(constMessages.companyNameCanNotBeNullOrEmpty);
		else if (!employerTelNumberCheck(employer))
			return new ErrorResult(constMessages.telCanNotBeNullOrEmpty);
		else if (!employerWebsiteCheck(employer))
			return new ErrorResult(constMessages.websiteCanNotBeNullOrEmpty);
		else if (!employerIsReal(employer))
			return new ErrorResult(constMessages.employerEmailAndWebsiteNotMatch);
		else if (!employerIsExist(employer))
			return new ErrorResult(constMessages.employerIsExist);
		else if (!employerPasswordCheck(employer))
			return new ErrorResult (constMessages.passwordCanNotBeNullOrEmpty + " veya " + constMessages.passwordLeastCharacter.replace("`n`", "6"));
		return new SuccessResult(constMessages.employerTempAdded);
	}
	
	private boolean employerIsExist (Employer employer) {
		var employerList=employerDao.findAll();
		
		for (Employer check : employerList) {
			if (check.getUserEmail().equals(employer.getUserEmail()))
				return false;		
		}
		return true;		
	}
	
	private boolean employerIsReal (Employer employer) {
		String brace1= "@";
		String brace2= "ww..";
		String[] website = employer.getCorporateUserWebsite().split(brace2,2);
		String[] mail = employer.getUserEmail().split(brace1);
		
		if ( website[1].equals(mail[1]) ) {
			return true;
		} else
			return false;
	}
	
	private boolean  employerTitleCheck (Employer employer) {
		if (employer.getCorporateUserTitle().length()==0 ||employer.getCorporateUserTitle()==null)
			return false;	
		return true;
	}

	private boolean  employerTelNumberCheck (Employer employer) {
		if (employer.getCorporateUserNumber().length()==0 || employer.getCorporateUserNumber()==null)
			return false;	
			return true;
	}
	
	private boolean  employerWebsiteCheck (Employer employer) {
		if (employer.getCorporateUserWebsite().length()==0 || employer.getCorporateUserWebsite()==null)
			return false;	
			return true;
	}
	
	private boolean  employerPasswordCheck (Employer employer) {
		if (employer.getUserPassword().length()==0 || employer.getUserPassword()==null)
			return false;
		if (employer.getUserPassword().length()<6)
			return false;
		
		return true;
	}
}
