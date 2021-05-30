package project.hrms.business.concretes;

import java.util.List;

import javax.validation.Validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.CandidateService;
import project.hrms.business.abstracts.CandidateValidationService;
import project.hrms.core.adapters.abstracts.EmailSendService;
import project.hrms.core.adapters.abstracts.FakeCandidateMernisService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.CandidateDao;
import project.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private final CandidateDao candidateDao;
	private final EmailSendService emailSendService;
	private CandidateValidationService candidateValidationService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, EmailSendService emailSendService,
		 CandidateValidationService candidateValidationService) {
		super();
		this.candidateDao = candidateDao;
		this.emailSendService = emailSendService;
		this.candidateValidationService = candidateValidationService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"İş arayanlar listelendi");
	}


	@Override
	public Result add(Candidate candidate) {
		
		if (candidateValidationService.validate(candidate) instanceof SuccessResult) {
			Result result =  candidateValidationService.validate(candidate);
			this.candidateDao.save(candidate);
			//this.emailSendService.sendEmail(candidate);
			return result;
			}
		return candidateValidationService.validate(candidate);
		
	}
	
}
