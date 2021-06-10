package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.MailVerifyService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.ErrorResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private UserDao userDao;
	private MailVerifyService mailVerifyService;

	
	@Autowired
	public EmployerManager(EmployerDao employerDao, UserDao userDao, MailVerifyService mailVerifyService) {
		super();
		this.employerDao = employerDao;
		this.userDao = userDao;
		this.mailVerifyService = mailVerifyService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İş verenler listesi listelendi.");
	}

	@Override
	public Result verifyAndAddEmployer(Employer employer) {

		String[] splitMail = employer.getMail().split("@");
		//String[] splitWebAddress = employer.getWebAddress().split(".");
		if (!splitMail[1].equals(employer.getWebAddress())) {
			return new ErrorResult("Mail adresinizin uzantısı web adresinizin uzantısı ile aynı olmalıdır.");
		}
		else if (this.userDao.existsByMail(employer.getMail())) {
			return new ErrorResult("Bu mail ile daha önce kayıt yapılmış..");
		}
		else if (!employer.getPassword().equals(employer.getPasswordRepeat())) {
			return new ErrorResult("Şifre - Şifre tekrarı alanları aynı olmalıdır.");
		}
		this.employerDao.save(employer);
		this.mailVerifyService.createVerifyCode(userDao.getOne(employer.getId()));
		this.mailVerifyService.sendMail(employer.getMail());
		return new SuccessResult("Başarıyla kayıt olundu.");
	}
	
}
