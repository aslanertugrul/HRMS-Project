package project.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name="jobs")
@AllArgsConstructor
@NoArgsConstructor
public class Job{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_id")
	private int jobID;
	
	@ManyToOne
	@JoinColumn(name = "job_field_id")
	private Job jobPosition;

	@Column(name="job_detail")
	private String jobDetail;
	
	@Column(name="job_owner_id")
	private int jobOwnerId;

	@Column(name="job_location")
	private String jobLocation;


	@Column(name="min_salary")
	private double jobMinSalary;


	@Column(name="max_salary")
	private double jobMaxSalary;


	@Column(name="job_quota")
	private int jobQuota;


	@Column(name="job_publish_date")
	private LocalDate createdDate = LocalDate.now();


	@Column(name="job_last_app_date")
	private LocalDate jobAppTerminationDate;


	@Column(name="job_status")
	private boolean jobStatus;
	
}
