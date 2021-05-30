package project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiParam;
import project.hrms.business.abstracts.JobService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Job;
import project.hrms.entities.dto.ActiveJobDto;



@RestController 
@RequestMapping("/api/jobs")
public class JobController {

	
	private JobService jobService;
	
	@Autowired
	public JobController(JobService jobService) {
		super();
		this.jobService = jobService;
	}

	@GetMapping(value = "/getalljobs")
	public DataResult<List<Job>> getAll() {
		return this.jobService.getAll();
	}
	
	@GetMapping(value = "/getallactivejobs")
	public DataResult<List<ActiveJobDto>> getAllActives(@RequestParam boolean status) {
		return this.jobService.getByJobStatus(status);
	}
	
	@GetMapping(value = "/getallactives_fromemployer")
	public DataResult<List<ActiveJobDto>> getByJobStatusAndJobOwnerId(@RequestParam int id ) {
		return this.jobService.getByJobStatusAndJobOwnerId(true,id);
	}
	
	@GetMapping(value = "/getallactivessorted")
	public DataResult<List<ActiveJobDto>> getAllActivesSorted(@RequestParam boolean status) {
		return this.jobService.findAllByJobStatusOrderByJobPublishDateDesc(status);
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestBody Job newJob) {
		return this.jobService.add(newJob);
	}
	
	@PostMapping(value = "/addforemployers")
	public Result addForEmployers(@RequestBody Job newJob , @RequestParam int jobField) {
		return this.jobService.addForEmployers(newJob, jobField);
	}
	
	@PostMapping(value = "/update")
	public Result update(@RequestBody Job updatedJob) {
		return this.jobService.update(updatedJob);
	}
	
	@PostMapping(value = "/makepassive")
	public Result makePassive(@RequestParam int jobId , @RequestParam int employerId) {
		return this.jobService.makePassive(jobId,employerId);
	}


}
