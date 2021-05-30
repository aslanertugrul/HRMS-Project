package project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.JobService;
import project.hrms.entities.concretes.JobPosition;



@RestController 
@RequestMapping("/api/jobs/")
public class JobsController {


	private JobService jobService;
	
	@Autowired
	public JobsController(JobService jobService) {
		super();
		this.jobService = jobService;
	}

	@GetMapping("/getall")
	public List<JobPosition> getAll() {
		return this.jobService.getAll();
	}
	
	
	
	
}
