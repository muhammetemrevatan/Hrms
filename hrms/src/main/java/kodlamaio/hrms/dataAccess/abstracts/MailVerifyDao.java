package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.MailVerify;

public interface MailVerifyDao extends JpaRepository<MailVerify, Integer>{
	
	MailVerify getByVerifyCode(String Code);
	boolean existsByVerifyCode(String Code);
	
}

