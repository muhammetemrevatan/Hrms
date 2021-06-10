package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.concretes.SchoolInfo;

public interface SchoolInfoDao extends JpaRepository<SchoolInfo, Integer>{
	
	List<SchoolInfo> getByCv(Resume resume);
	List<SchoolInfo> findAllByCvId(int id);
}
