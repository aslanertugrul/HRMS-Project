package project.hrms.core.adapters.concretes;

import org.springframework.stereotype.Service;

import project.hrms.core.adapters.abstracts.EmailSendService;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.entities.concretes.User;

@Service
public class EmailSendManager implements EmailSendService {

	@Override
	public Result sendEmail(User user) {
		return new SuccessResult("Email başarıyla gönderildi: " + user.getUserEmail());
	}

}
