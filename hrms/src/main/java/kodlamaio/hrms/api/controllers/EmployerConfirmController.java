package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployeeConfirmService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.EmployeeConfirm;

@RestController
@RequestMapping("api/employeeConfirmedEmployer")
public class EmployerConfirmController {
	
	private EmployeeConfirmService employeeConfirmService;

	@Autowired
	public EmployerConfirmController(EmployeeConfirmService employeeConfirmService) {
		super();
		this.employeeConfirmService = employeeConfirmService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<EmployeeConfirm>> getAll() {
		return this.employeeConfirmService.getAll();
	}
	
	@PutMapping("/employerConfirmed")
	public Result employerConfirmed(int employerId, int employeeId) {
		
		return this.employeeConfirmService.employerConfirmed(employerId,employeeId);
	}
}
