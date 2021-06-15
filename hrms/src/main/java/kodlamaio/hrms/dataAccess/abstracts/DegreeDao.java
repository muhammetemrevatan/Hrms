package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.Degree;

@Repository
public interface DegreeDao extends JpaRepository<Degree, Integer>{

}
