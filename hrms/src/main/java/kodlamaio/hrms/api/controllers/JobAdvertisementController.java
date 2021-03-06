package kodlamaio.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.ErrorDataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.dtos.JobAdvertisementAddDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementShowDto;

@RestController
@RequestMapping("/api/jobadvertisements")
@CrossOrigin
public class JobAdvertisementController {
	
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getallsorteddate")
	public DataResult<List<JobAdvertisementShowDto>> getAllSortedDate() {
		return this.jobAdvertisementService.getAllSortedDate();
	}
	
	@GetMapping("getallactiveandconfirm")
	public DataResult<List<JobAdvertisementShowDto>> getAllActiveAndConfirm() {
		return this.jobAdvertisementService.getAllActiveAndConfirm();
	}
	
	@GetMapping("getall")
	public DataResult<List<JobAdvertisementShowDto>> getAll() {
		return this.jobAdvertisementService.getAll();
	}
	
	@PutMapping("/{jobAdvertisementId}")
	public Result updateDisable(@PathVariable("jobAdvertisementId") int jobAdvertisementId) {
		return this.jobAdvertisementService.updateDisable(jobAdvertisementId);
	}
	
	@PutMapping("/confirm/{jobAdvertisementId}")
	public Result updateEmployeeConfirmTrue(@PathVariable("jobAdvertisementId") int jobAdvertisementIdd) {
		return this.jobAdvertisementService.updateEmployeeConfirmTrue(jobAdvertisementIdd);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobAdvertisementAddDto jobAdvertisementAddDto) {
		return ResponseEntity.ok(this.jobAdvertisementService.add(jobAdvertisementAddDto));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String,String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Do??rulama hatalar??");
		return errors;
	}
	
}
