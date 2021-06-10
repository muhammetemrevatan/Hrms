package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.DegreeService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.DegreeDao;
import kodlamaio.hrms.entities.concretes.Degree;

@Service
public class DegreeManager implements DegreeService{

	private DegreeDao degreeDao;
	
	
	@Autowired
	public DegreeManager(DegreeDao degreeDao) {
		super();
		this.degreeDao = degreeDao;
	}

	@Override
	public Result addDegree(Degree degree) {
		this.degreeDao.save(degree);
		return new SuccessResult("Derece başarıyla eklendi");
	}

	@Override
	public DataResult<List<Degree>> getAll() {
		return new SuccessDataResult<List<Degree>>(this.degreeDao.findAll(),"Tüm dereceler listelendi.");
	}

}
