package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Resume;

public interface ResumeDao extends JpaRepository<Resume, Integer>{
	
	boolean existsByPhoto(String photo);

	@Query("From Resume where candidate.id=:candidateId")
	List<Resume> getByCandidate(int candidateId);
}
