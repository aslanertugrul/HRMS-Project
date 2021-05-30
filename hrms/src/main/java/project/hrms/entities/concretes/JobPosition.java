package project.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import project.hrms.entities.abstracts.Entity;

@Data
@javax.persistence.Entity
@Table(name="job_titles")

public class JobPosition implements Entity {

	@Id
	@GeneratedValue
	
	@Column(name="job_id")
	private int jobID;
	
	@Column(name="job_detail")
	private String jobDetail;
	
	@Column(name="employer_id")
	private int employerID;

	public JobPosition() {
		super();
	}
	
	public JobPosition(int jobID, String jobDetail, int employerID) {
		super();
		this.jobID = jobID;
		this.jobDetail = jobDetail;
		this.employerID = employerID;
	}

	
	
}
