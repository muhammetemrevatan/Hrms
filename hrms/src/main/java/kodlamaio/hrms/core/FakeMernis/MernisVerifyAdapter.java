package kodlamaio.hrms.core.FakeMernis;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class MernisVerifyAdapter implements MernisVerifyService<Candidate>{

	@Override
	public boolean VerifyApiControl(Candidate candidate) {
		return true;
	}
	
}
