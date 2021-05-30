package project.hrms.core.adapters.abstracts;

import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.User;


public interface EmailSendService {
	Result sendEmail(User user);
}
