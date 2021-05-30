package project.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="candidates") 

public class Candidate extends RealUser {
	
	@Column(name="identity_number") 
	private String candidateIdentityNumber; 
	
	@Column(name="birth_date") 
	private int candidateBirthDate;  
	
	@Column(name="is_activated") 
	private boolean candidateIsActivated;  

}
