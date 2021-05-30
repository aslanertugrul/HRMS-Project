package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.CandidateValidationService;
import project.hrms.core.utilities.results.ErrorDataResult;
import project.hrms.core.utilities.results.ErrorResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.core.utilities.tools.RunTools;
import project.hrms.dataAccess.abstracts.CandidateDao;
import project.hrms.entities.concretes.Candidate;

@Service
public class CandidateValidationManager implements CandidateValidationService {

	private CandidateDao candidateDao;	
	
	@Autowired
	public CandidateValidationManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	@Override
	public Result validate(Candidate candidate) {
		
		if (!candidateNameCheck(candidate))
			return new ErrorResult(constMessages.firstNameCanNotBeNullOrEmpty); 
				else if (!candidateSurnameCheck(candidate))
				return new ErrorResult(constMessages.lastNameCanNotBeNullOrEmpty);	
					else if (!candidateIdentityNumberCheck(candidate))
					return new ErrorResult(constMessages.identityNumberCanNotBeNullOrEmpty);
						else if (!candidateEmailCheck(candidate))
						return new ErrorResult(constMessages.emailCanNotBeNullOrEmpty);
							else if (!candidatePasswordCheck(candidate))
							return new ErrorResult (constMessages.passwordCanNotBeNullOrEmpty + " veya " + constMessages.passwordLeastCharacter.replace("`n`", "6"));
								else if (!candidateBirthDateCheck(candidate))
								return new ErrorResult(constMessages.birtDateCanNotBeNullOrEmpty);
									else if (!candidateIsExist(candidate))
									return new ErrorResult(constMessages.emailAlreadyExists + " veya " + constMessages.identityNumberAlreadyExists);
		return new SuccessResult(constMessages.succesfulUserAdd);
	} 
		
	private boolean  candidateNameCheck (Candidate candidate) {
		if (candidate.getRealUserName().length()==0 || candidate.getRealUserName()==null)
			return false;	
		return true;
	}
	
	private boolean  candidateSurnameCheck (Candidate candidate) {
		if (candidate.getRealUserSurname().length()==0 || candidate.getRealUserSurname()==null)
			return false;	
			return true;
	}
	
	private boolean  candidateIdentityNumberCheck (Candidate candidate) {
		if (candidate.getCandidateIdentityNumber().length()!=11 || candidate.getCandidateIdentityNumber()==null)
			return false;	
			return true;
	}
	
	private boolean  candidateBirthDateCheck (Candidate candidate) {
		if (candidate.getCandidateBirthDate()<1900 )
			return false;	
			return true;
	}
	
	private boolean  candidateEmailCheck (Candidate candidate) {
		if (candidate.getUserEmail().length()==0 || candidate.getUserEmail()==null)
			return false;	
			return true;
	}
	
	private boolean  candidatePasswordCheck (Candidate candidate) {
		if (candidate.getUserPassword().length()==0 || candidate.getUserPassword()==null)
			return false;
		if (candidate.getUserPassword().length()<6)
			return false;
		
		return true;
	}
	
	
	private boolean  candidateIsExist (Candidate candidate)  {
		var candidateList=this.candidateDao.findAll();
		
		for (Candidate check : candidateList) {
			if (check.getUserEmail().equals(candidate.getUserEmail()))
				return false;
			else if (check.getCandidateIdentityNumber().equals(candidate.getCandidateIdentityNumber()))
				return false;
		}
		return true;
	}



}
