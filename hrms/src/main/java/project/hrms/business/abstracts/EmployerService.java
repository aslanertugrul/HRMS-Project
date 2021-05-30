package project.hrms.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Employer;


public interface EmployerService {

	DataResult<List<Employer>> getAll();
	Result add(Employer employer);
	
}
