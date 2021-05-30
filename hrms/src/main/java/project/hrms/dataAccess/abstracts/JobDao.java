package project.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.entities.concretes.Job;
import project.hrms.entities.dto.ActiveJobDto;

public interface JobDao extends JpaRepository < Job, Integer > {

	List<Job> getByJobStatus(boolean status);
	List<Job> getByJobStatusAndJobOwnerId(boolean status , int id);
	List<ActiveJobDto> findAllByJobStatusOrderByCreatedDateDesc(boolean status);
	Job getByJobID(int id);

}
