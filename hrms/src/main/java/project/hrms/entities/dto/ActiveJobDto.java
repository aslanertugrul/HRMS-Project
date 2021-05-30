package project.hrms.entities.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActiveJobDto {

	private int employerId;
	private String jobDetail;
	private int jobQuote;
	private LocalDate jobPublishDate;
	
	
	
}
