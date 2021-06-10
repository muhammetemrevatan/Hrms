package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.MailVerify;
import kodlamaio.hrms.entities.concretes.User;

public interface MailVerifyService {

	String createVerifyCode(User user);
	void sendMail(String mail);
	Result verifyUser(String code);
	DataResult<List<MailVerify>> getAll();
	
}
