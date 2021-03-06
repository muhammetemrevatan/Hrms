package kodlamaio.hrms.business.concretes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.ErrorResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementAddDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementShowDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementsDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementsDao,DtoConverterService dtoConverterService) {
		super();
		this.jobAdvertisementsDao = jobAdvertisementsDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public DataResult<List<JobAdvertisementShowDto>> getAllSortedDate() {
		Sort sort = Sort.by(Sort.Direction.DESC,"createdDate");
		return new SuccessDataResult<List<JobAdvertisementShowDto>>
		(dtoConverterService.dtoConverter(jobAdvertisementsDao.findAll(sort), JobAdvertisementShowDto.class),"Listeleme başarılı");
	}

	@Override
	public DataResult<List<JobAdvertisementShowDto>> getAllActiveAndConfirm() {
		return new SuccessDataResult<List<JobAdvertisementShowDto>>
		(dtoConverterService.dtoConverter(jobAdvertisementsDao.findAllByIsActiveTrueAndEmployeeConfirmTrue(), JobAdvertisementShowDto.class),"Listeleme başarılı");
	}

	@Override
	public Result updateDisable(int jobAdvertisementId) {
		if(jobAdvertisementsDao.findById(jobAdvertisementId) == null) {
			return new ErrorResult("Bu id'ye ait bir iş ilanı bulunamadı.");
		}
		JobAdvertisement jobAdvertisement = jobAdvertisementsDao.getOne(jobAdvertisementId);
		if(jobAdvertisement.isActive() == false) {
			return new ErrorResult("İlan zaten deaktif durumda.");
		}
		jobAdvertisement.setActive(true);
		jobAdvertisementsDao.save(jobAdvertisement);
		return new SuccessResult("İlan deaktif duruma getirildi.");
	}
	
	@Override
	public Result add(JobAdvertisementAddDto jobAdvertisementAddDto) {
		LocalDate date = (LocalDate.now());
		jobAdvertisementAddDto.setCreatedDate(Date.valueOf(date));
		jobAdvertisementAddDto.setActive(true);
		jobAdvertisementAddDto.setEmployeeConfirm(false);
		jobAdvertisementsDao.save((JobAdvertisement) dtoConverterService.dtoClassConverter(jobAdvertisementAddDto,JobAdvertisement.class));
		return new SuccessResult("Başarıyla kayıt oldunuz.");
	}

	@Override
	public DataResult<List<JobAdvertisementShowDto>> getAll() {
		return new SuccessDataResult<List<JobAdvertisementShowDto>>
		(dtoConverterService.dtoConverter(jobAdvertisementsDao.findAll(), JobAdvertisementShowDto.class),"Listeleme başarılı");
	}

	@Override
	public Result updateEmployeeConfirmTrue(int jobAdvertisementIdd) {
		if(!jobAdvertisementsDao.existsById(jobAdvertisementIdd)) {
			return new SuccessResult("Bu id'ye ait bir iş ilanı yok");
		}
		JobAdvertisement jobAdvertisement = jobAdvertisementsDao.getOne(jobAdvertisementIdd);
		jobAdvertisement.setEmployeeConfirm(true);
		jobAdvertisementsDao.save(jobAdvertisement);
		return new SuccessResult("İlan onaylandı.");
	}
}
