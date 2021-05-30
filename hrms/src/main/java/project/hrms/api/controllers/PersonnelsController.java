package project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.PersonnelService;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Candidate;
import project.hrms.entities.concretes.Employer;
import project.hrms.entities.concretes.Personnel;

@RestController 
@RequestMapping("/api/personnel/")
public class PersonnelsController {

	private PersonnelService personnelService;

	@Autowired
	public PersonnelsController(PersonnelService personnelService) {
		super();
		this.personnelService = personnelService;
	}


	public PersonnelsController() {
		super();
	}


	@GetMapping("/getall")
	public List<Personnel> getAll() {
		return this.personnelService.getAll();
	}
	
	@PostMapping("/confirmation")
	public Result confirm(@RequestBody int id) {
		return this.personnelService.confirm(id);
	} 
}
