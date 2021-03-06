package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Repository
public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	
	List<JobAdvertisement> getById(String message);
	
	List<JobAdvertisement> findAllByIsActiveTrueAndEmployeeConfirmTrue();
	
	List<JobAdvertisement> findByEmployeeConfirmTrue();
	

	JobAdvertisement findById(int jobAdvertisementId);
	
	@Query("From kodlamaio.hrms.entities.concretes.JobAdvertisement where employer.id=:employerId")
	JobAdvertisement getbyEmployerId(int employerId);
	
	
	
}
