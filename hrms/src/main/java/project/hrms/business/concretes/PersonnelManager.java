package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.PersonnelService;
import project.hrms.core.utilities.results.ErrorResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.EmployerDao;
import project.hrms.dataAccess.abstracts.PersonnelDao;
import project.hrms.entities.concretes.Employer;
import project.hrms.entities.concretes.Personnel;

@Service
public class PersonnelManager implements PersonnelService{

	private PersonnelDao personnelDao;
	private EmployerDao employerDao;
	
	@Autowired
	public PersonnelManager(PersonnelDao personnelDao, EmployerDao employerDao) {
		super();
		this.personnelDao = personnelDao;
		this.employerDao = employerDao;
	}


	@Override
	public List<Personnel> getAll() {
		return this.personnelDao.findAll();
	}

	@Override
	public Result confirm(int id) {
		var employerList=employerDao.findAll();
		
		for (Employer employer : employerList) {
			if (employer.getUserId()==id) {
				if (employer.isEmployerIsConfirmed()==true)
					return new ErrorResult ("Kullanıcı zaten HR onaylıdır.");
				else
					return new SuccessResult("Kullanıcının HR onayı verildi.");
					}
			}
				return new ErrorResult("Böyle bir kullanıcı bulunmamaktadır!");
			}

		
	}

