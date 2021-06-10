package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Degree;

public interface DegreeDao extends JpaRepository<Degree, Integer>{

}
