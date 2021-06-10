package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.EmployeeConfirm;

public interface EmployeeConfirmService {

	Result employerConfirmed(int employerId,int employeeId);
	DataResult<List<EmployeeConfirm>> getAll();
}
