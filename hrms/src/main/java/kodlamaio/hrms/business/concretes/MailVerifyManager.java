package kodlamaio.hrms.business.concretes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.MailVerifyService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.ErrorResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.MailVerifyDao;
import kodlamaio.hrms.entities.concretes.MailVerify;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class MailVerifyManager implements MailVerifyService{
	
	private MailVerifyDao mailVerifyDao;
	
	@Autowired
	public MailVerifyManager(MailVerifyDao mailVerifyDao) {
		super();
		this.mailVerifyDao = mailVerifyDao;
	}

	@Override
	public String createVerifyCode(User user) {
		String vCode = UUID.randomUUID().toString();
		MailVerify mailVerify = new MailVerify();
		LocalDate date = (LocalDate.now());
		mailVerify.setUser(user);
		mailVerify.setCreatedDate(Date.valueOf(date));
		mailVerify.setVerifyCode(UUID.randomUUID().toString());
		this.mailVerifyDao.save(mailVerify);
		return vCode;
	}

	@Override
	public void sendMail(String mail) {
		System.out.println("Doğrulama maili gönderildi. : " + mail);
	}

	@Override
	public Result verifyUser(String code) {
		
		if(!this.mailVerifyDao.existsByVerifyCode(code)) {
			return new ErrorResult("Yanlış kod!");
		}
		MailVerify mailVerify = mailVerifyDao.getByVerifyCode(code);
		LocalDate date = (LocalDate.now());
		mailVerify.setVerified(true);
		mailVerify.setComfirmedDate(Date.valueOf(date));
		mailVerifyDao.save(mailVerify);
		return new SuccessResult("Kod başayıtla doğrulandı.");
	}

	@Override
	public DataResult<List<MailVerify>> getAll() {
		return new SuccessDataResult<List<MailVerify>>(this.mailVerifyDao.findAll(),"MailVerify tablosu listelendi.");
	}
}
