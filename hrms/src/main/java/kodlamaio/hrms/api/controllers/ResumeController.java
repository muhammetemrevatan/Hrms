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
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.BusinessExperienceAddDto;
import kodlamaio.hrms.entities.dtos.ForeignLanguageAddDto;
import kodlamaio.hrms.entities.dtos.ResumeAddDto;
import kodlamaio.hrms.entities.dtos.ResumeShowDto;
import kodlamaio.hrms.entities.dtos.SchoolInfoAddDto;
import kodlamaio.hrms.entities.dtos.TechnologyAddDto;

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {
	
	private ResumeService resumeService;

	@Autowired
	public ResumeController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}
	
	@PutMapping("/{candidate}")
	public DataResult<List<ResumeShowDto>> getAllCandidateCv(@PathVariable("candidate") Candidate candidate) {
		return resumeService.getAllCandidateCv(candidate);
	}
	
	@PostMapping("/addResume")
	public  ResponseEntity<?> addResume(@Valid @RequestBody ResumeAddDto resumeAddDto) {
		return ResponseEntity.ok(this.resumeService.addResume(resumeAddDto));
	}
	
	@PostMapping("/addBusinessExperience")
	public ResponseEntity<?> addBusinessExperience(@Valid @RequestBody BusinessExperienceAddDto businessExperienceAddDto ) {
		return ResponseEntity.ok(this.resumeService.addBusinessExperience(businessExperienceAddDto ));
	}
	
	@PostMapping("/addForeignLanguage")
	public ResponseEntity<?> addForeignLanguage(@Valid @RequestBody ForeignLanguageAddDto foreignLanguageAddDto ) {
		return ResponseEntity.ok(this.resumeService.addForeignLanguage(foreignLanguageAddDto ));
	}
	
	@PostMapping("/addSchoolInfo")
	public ResponseEntity<?> addSchoolInfo(@Valid @RequestBody SchoolInfoAddDto schoolInfoAddDto) {
		return ResponseEntity.ok(this.resumeService.addSchoolInfo(schoolInfoAddDto));
	}
	
	@PostMapping("/addTechnology")
	public ResponseEntity<?> addTechnology(@Valid @RequestBody TechnologyAddDto technologyAddDto) {
		return ResponseEntity.ok(this.resumeService.addTechnology(technologyAddDto));
	}
	
	@PutMapping("/uploadPhoto")
	public ResponseEntity<?> savePhoto(@RequestBody MultipartFile file,@RequestParam int resumeId){
		return ResponseEntity.ok(this.resumeService.savePhoto(file, resumeId));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String,String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
		return errors;
	}
	
	
}
