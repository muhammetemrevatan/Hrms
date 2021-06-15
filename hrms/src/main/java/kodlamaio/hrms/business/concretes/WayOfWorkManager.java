package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WayOfWorkService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.WayOfWorkDao;
import kodlamaio.hrms.entities.concretes.WayOfWork;

@Service
public class WayOfWorkManager implements WayOfWorkService{
	
	private WayOfWorkDao wayOfWorkDao;

	@Autowired
	public WayOfWorkManager(WayOfWorkDao wayOfWorkDao) {
		super();
		this.wayOfWorkDao = wayOfWorkDao;
	}

	@Override
	public DataResult<List<WayOfWork>> getAll() {
		return new SuccessDataResult<List<WayOfWork>>(this.wayOfWorkDao.findAll(),"Çalışma Zamanı Listelendi");
	}
}
