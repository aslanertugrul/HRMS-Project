package project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.JobFieldService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.entities.concretes.Job;
import project.hrms.entities.concretes.JobField;

@RestController 
@RequestMapping("/api/jobfield")
public class JobFieldController {

	private JobFieldService jobFieldService;

	@Autowired
	public JobFieldController(JobFieldService jobFieldService) {
		super();
		this.jobFieldService = jobFieldService;
	}
	
	@GetMapping(value = "/getalljobfields")
	public DataResult<List<JobField>> getAll() {
		return this.jobFieldService.getAll() ;
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestBody JobField newJobField) {
		return this.jobFieldService.add(newJobField);
	}
	
}
