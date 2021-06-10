package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.Candidate;

@Repository
public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	
	boolean existsByIdentityNumber(String identityNumber);
	
	boolean existsById(int candidateId);
	
	Candidate getById(int id);
}
