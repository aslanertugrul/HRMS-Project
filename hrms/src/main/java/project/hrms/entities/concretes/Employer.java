package project.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employers") 
@PrimaryKeyJoinColumn(name="id", referencedColumnName="id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","job_titles"})

public class Employer  extends User {


	@Column(name="employer_title")
	private String corporateUserTitle;  
	 
	@Column(name="website")
	private String corporateUserWebsite;  
		
	@Column(name="number")
	private String corporateUserNumber; 
	
	@Column(name="IsConfirmed") 
	private boolean employerIsConfirmed; 
	
}
 