package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.ErrorDataResult;
import kodlamaio.hrms.core.results.ErrorResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService{

	private EmployeeDao employeeDao;
	private UserDao userDao;
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao,UserDao userDao) {
		super();
		this.employeeDao = employeeDao;
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		if(this.employeeDao.findAll() == null) {
			return new ErrorDataResult<List<Employee>>(null,"Henüz bir çalışan eklenmedi. Lütfen ilk önce çalışan ekleyiniz.");
		}
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(),"Çalışanlar listelendi.");
	}

	@Override
	public Result add(Employee employee) {
		if(this.userDao.existsByMail(employee.getMail())) {
			return new ErrorResult("Aynı mail adresi ile tekrar kayıt olunamaz.");
		}
		employee.setActivated(true);
		this.employeeDao.save(employee);
		return new SuccessResult("Çalışan kaydedildi.");
	}

	

}
