package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.Personnel;

public interface PersonnelDao extends JpaRepository < Personnel, Integer >  {

}
