package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.entities.concretes.Technology;

public interface TechnologyService {
	
	DataResult<List<Technology>> getAll();
	
}
