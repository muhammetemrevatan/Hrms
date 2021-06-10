package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.Degree;

public interface DegreeService {
	

	Result addDegree(Degree degree);
	DataResult<List<Degree>> getAll();
}
