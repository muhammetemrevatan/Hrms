package kodlamaio.hrms.core.FakeMernis;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface MernisVerifyService<T> {
	
	boolean VerifyApiControl(Candidate candidata);

}
