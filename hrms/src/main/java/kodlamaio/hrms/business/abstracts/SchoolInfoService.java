package kodlamaio.hrms.business.abstracts;

import java.util.List;


import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.entities.concretes.SchoolInfo;

public interface SchoolInfoService {
	
	DataResult<List<SchoolInfo>> getAll();
	
}
