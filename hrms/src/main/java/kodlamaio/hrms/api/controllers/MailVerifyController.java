package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.MailVerifyService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.MailVerify;

@RestController
@RequestMapping("api/mailVerifyCodes")
public class MailVerifyController {
	
	private MailVerifyService mailVerifyService;

	@Autowired
	public MailVerifyController(MailVerifyService mailVerifyService) {
		super();
		this.mailVerifyService = mailVerifyService;
	}
	
	@PutMapping("/{verifyCode}")
	public Result updateVerifyCode(@PathVariable("verifyCode") String verifyCode) {
		return mailVerifyService.verifyUser(verifyCode);
	}
	
	@GetMapping("/getall")
	public DataResult<List<MailVerify>> getAll(){
		return this.mailVerifyService.getAll();
	}
	
	
}
