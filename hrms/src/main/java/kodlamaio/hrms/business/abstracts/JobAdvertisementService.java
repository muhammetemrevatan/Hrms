package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.dtos.JobAdvertisementAddDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementShowDto;

public interface JobAdvertisementService {
	
	DataResult<List<JobAdvertisementShowDto>> getAllSortedDate();
	DataResult<List<JobAdvertisementShowDto>> getAllActiveAndConfirm();
	DataResult<List<JobAdvertisementShowDto>> getAll();
	Result updateDisable(int jobAdvertisementId);
	Result updateEmployeeConfirmTrue(int jobAdvertisementId);
	Result add(JobAdvertisementAddDto jobAdvertisementAddDto);
}
