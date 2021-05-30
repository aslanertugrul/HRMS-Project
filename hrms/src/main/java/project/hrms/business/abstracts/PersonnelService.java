package project.hrms.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Employer;
import project.hrms.entities.concretes.Personnel;


public interface PersonnelService {

	List<Personnel> getAll();
	Result confirm(int id);
}
