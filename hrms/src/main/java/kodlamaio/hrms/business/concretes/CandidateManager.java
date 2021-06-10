package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.MailVerifyService;
import kodlamaio.hrms.core.FakeMernis.MernisVerifyService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.ErrorResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{
	
	private CandidateDao candidateDao;
	private UserDao userDao;
	private MernisVerifyService<Candidate> verifyApiService;
	private MailVerifyService mailVerifySerice;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, UserDao userDao,
			MernisVerifyService<Candidate> verifyApiService, MailVerifyService mailVerifySerice) {
		super();
		this.candidateDao = candidateDao;
		this.userDao = userDao;
		this.verifyApiService = verifyApiService;
		this.mailVerifySerice = mailVerifySerice;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"Adaylar listesi getirildi.");
	}

	@Override
	public Result verifyAndAddCandidate(Candidate candidate) {
		if(!this.verifyApiService.VerifyApiControl(candidate)) {
			return new ErrorResult("Mernis doğrulaması başarısız.");
		}
		else if (this.userDao.existsByMail(candidate.getMail())) {
			return new ErrorResult("Aynı mail adresi ile tekrar kayıt olunamaz.");
		}
		else if (candidateDao.existsByIdentityNumber(candidate.getIdentityNumber())) {
			return new ErrorResult("Kimlik numarası ile daha önce kayıt yapılmış.");
		}		
		else if (!candidate.getPassword().equals(candidate.getPasswordRepeat())) {
			return new ErrorResult("Şifre - Şifre tekrarı alanları aynı olmalıdır.");
		}
		this.candidateDao.save(candidate);
		this.mailVerifySerice.createVerifyCode(userDao.getOne(candidate.getId()));
		this.mailVerifySerice.sendMail(candidate.getMail());
		return new SuccessResult("Sisteme başarıyla kayıt oldunuz.");
	}
	
}
