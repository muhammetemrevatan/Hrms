package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.WayOfWork;

@Repository
public interface WayOfWorkDao extends JpaRepository<WayOfWork, Integer>{

}
