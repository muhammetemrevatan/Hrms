package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.entities.concretes.WayOfWork;

public interface WayOfWorkService {

	DataResult<List<WayOfWork>> getAll();
}
