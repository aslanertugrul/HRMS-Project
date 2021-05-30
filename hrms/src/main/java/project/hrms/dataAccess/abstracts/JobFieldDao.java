package project.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.Job;
import project.hrms.entities.concretes.JobField;

public interface JobFieldDao extends JpaRepository < JobField, Integer >{

	List<JobField> getByTitle(String title);

}
