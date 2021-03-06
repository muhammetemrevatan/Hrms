package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.EmployeeConfirm;

@Repository
public interface EmployeeConfirmDao extends JpaRepository<EmployeeConfirm, Integer>{
	
	boolean existsByEmployerId(int employerId);
	
}
