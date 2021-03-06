package kodlamaio.hrms.business.concretes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeConfirmService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.ErrorResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeConfirmDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.EmployeeConfirm;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployeeConfirmManager implements EmployeeConfirmService{

	private EmployeeConfirmDao employeeConfirmDao;
	private EmployerDao employerDao;
	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeConfirmManager(EmployeeConfirmDao employeeConfirmDao, EmployerDao employerDao,EmployeeDao employeeDao) {
		super();
		this.employeeConfirmDao = employeeConfirmDao;
		this.employerDao = employerDao;
		this.employeeDao = employeeDao;
	}

	@Override
	public Result employerConfirmed(int employerId,int employeeId) {
		
		if(employerDao.getById(employerId) == null) {
			return new ErrorResult("Bu EmployerId 'ye ait bir veri yok.(Geçersiz veya yanlış employerId girdiniz.) Olmayan bir şirketi onaylayamazsınız.");
		}
		
		if(employeeDao.getById(employeeId) == null) {
			return new ErrorResult("Bu EmployeeId 'ye ait bir veri yok.(Geçersiz veya yanlış employeeId girdiniz.) Olmayan bir çalışan onay veremez.");
		}
		
		if(employeeConfirmDao.existsByEmployerId(employerId)) {
			return new ErrorResult("Bu şirket daha önce onaylanmış.");
		}
		
		Employer employer = employerDao.getOne(employerId);
		Employee employee = employeeDao.getOne(employeeId);
		EmployeeConfirm employeeConfirm = new EmployeeConfirm();
		LocalDate date = (LocalDate.now());
		employeeConfirm.setConfirmed(true);
		employeeConfirm.setConfirmedDate(Date.valueOf(date));
		employeeConfirm.setEmployer(employer);
		employeeConfirm.setEmployee(employee);
		employeeConfirmDao.save(employeeConfirm);
		return new SuccessResult(employee.getFirstName() + employee.getLastName() + " isimli çalışan '" + employer.getCompanyName() + "' isimli şirketi onayladı.");
	}

	@Override
	public DataResult<List<EmployeeConfirm>> getAll() {
		return new SuccessDataResult<List<EmployeeConfirm>>(this.employeeConfirmDao.findAll(),"Tüm onaylamalar listelendi..");
	}

}
