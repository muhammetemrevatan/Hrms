package kodlamaio.hrms.business.concretes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.cloudinary.CloudinaryService;
import kodlamaio.hrms.core.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.BusinessExperienceDao;
import kodlamaio.hrms.dataAccess.abstracts.ForeignLanguageDao;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.dataAccess.abstracts.SchoolInfoDao;
import kodlamaio.hrms.dataAccess.abstracts.TechnologyDao;
import kodlamaio.hrms.entities.concretes.BusinessExperience;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.ForeignLanguage;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.concretes.SchoolInfo;
import kodlamaio.hrms.entities.concretes.Technology;
import kodlamaio.hrms.entities.dtos.BusinessExperienceAddDto;
import kodlamaio.hrms.entities.dtos.BusinessExperienceShowDto;
import kodlamaio.hrms.entities.dtos.ForeignLanguageAddDto;
import kodlamaio.hrms.entities.dtos.ForeignLanguageShowDto;
import kodlamaio.hrms.entities.dtos.ResumeAddDto;
import kodlamaio.hrms.entities.dtos.ResumeShowDto;
import kodlamaio.hrms.entities.dtos.SchoolInfoAddDto;
import kodlamaio.hrms.entities.dtos.SchoolInfoShowDto;
import kodlamaio.hrms.entities.dtos.TechnologyAddDto;
import kodlamaio.hrms.entities.dtos.TechnologyShowDto;

@Service
public class ResumeManager implements ResumeService{

	private ResumeDao resumeDao;
	private SchoolInfoDao schoolInfoDao;
	private BusinessExperienceDao businessExperienceDao;
	private ForeignLanguageDao foreignLanguageDao;
	private TechnologyDao technologyDao; 
	private DtoConverterService dtoContertService;
	private CloudinaryService cloudinaryService;
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao,SchoolInfoDao schoolInfoDao, 
			BusinessExperienceDao businessExperienceDao,ForeignLanguageDao foreignLanguageDao, 
			TechnologyDao technologyDao,DtoConverterService dtoContertService,CloudinaryService cloudinaryService) {
		super();
		this.resumeDao = resumeDao;
		this.schoolInfoDao = schoolInfoDao;
		this.businessExperienceDao = businessExperienceDao;
		this.foreignLanguageDao = foreignLanguageDao;
		this.technologyDao = technologyDao;
		this.dtoContertService = dtoContertService;
		this.cloudinaryService = cloudinaryService;
	}

	@Override
	public DataResult<List<ResumeShowDto>> getAllCandidateCv(Candidate candidate) {
		List<ResumeShowDto> resumeShowDtoList = dtoContertService.dtoConverter(resumeDao.getByCandidate(candidate.getId()), ResumeShowDto.class);
		for (ResumeShowDto resumeShowDto : resumeShowDtoList) {
			List<BusinessExperience> findallByCv =  businessExperienceDao.findAllByCvId(resumeShowDto.getId());
			List<BusinessExperienceShowDto> businessExperienceShowDto = dtoContertService.dtoConverter(findallByCv, BusinessExperienceShowDto.class);
			if(!businessExperienceShowDto.isEmpty()) {
				resumeShowDto.setBusinessExperiences(businessExperienceShowDto);
			}
		}
		for (ResumeShowDto resumeShowDto : resumeShowDtoList) {
			List<ForeignLanguage> findallByCv = foreignLanguageDao.findAllByCvId(resumeShowDto.getId());
			List<ForeignLanguageShowDto> foreignLanguageShowDto = dtoContertService.dtoConverter(findallByCv, ForeignLanguageShowDto.class);
			if(!foreignLanguageShowDto.isEmpty()) {
				resumeShowDto.setForeignLanguages(foreignLanguageShowDto);
			}
		}
		for (ResumeShowDto resumeShowDto : resumeShowDtoList) {
			List<Technology> findallByCv = technologyDao.findAllByCvId(resumeShowDto.getId());
			List<TechnologyShowDto> technologyShowDto = dtoContertService.dtoConverter(findallByCv, TechnologyShowDto.class);
			if(!technologyShowDto.isEmpty()) {
				resumeShowDto.setTechnologies(technologyShowDto);
			}
		}
		for (ResumeShowDto resumeShowDto : resumeShowDtoList) {
			List<SchoolInfo> findallByCv = schoolInfoDao.findAllByCvId(resumeShowDto.getId());
			List<SchoolInfoShowDto> schoolInfoShowDto = dtoContertService.dtoConverter(findallByCv, SchoolInfoShowDto.class);
			if(!schoolInfoShowDto.isEmpty()) {
				resumeShowDto.setSchoolInfos(schoolInfoShowDto);
			}
		}
		
		return new SuccessDataResult<List<ResumeShowDto>>(resumeShowDtoList,"Adaya ait t??m CV'ler g??r??nt??lendi.");
	}

	@Override
	public Result addResume(ResumeAddDto resumeAddDto) {
		LocalDate date = (LocalDate.now());
		resumeAddDto.setCreatedDate(Date.valueOf(date));
		resumeAddDto.setLastUpdateDate(Date.valueOf(date));
		this.resumeDao.save((Resume)dtoContertService.dtoClassConverter(resumeAddDto, Resume.class));
		return new SuccessResult("CV ba??ar??yla eklendi.");
	}

	@Override
	public Result addBusinessExperience(BusinessExperienceAddDto businessExperienceAddDto) {
		LocalDate date = (LocalDate.now());
		businessExperienceAddDto.setCreatedDate(Date.valueOf(date));
		this.businessExperienceDao.save((BusinessExperience)dtoContertService.dtoClassConverter(businessExperienceAddDto, BusinessExperience.class));
		return new SuccessResult("Id numaras?? '" + businessExperienceAddDto.getCvId() + "' olan cv'ye i?? tecr??besi eklendi.");
	}

	@Override
	public Result addForeignLanguage(ForeignLanguageAddDto foreignLanguageAddDto) {
		LocalDate date = (LocalDate.now());
		foreignLanguageAddDto.setCreatedDate(Date.valueOf(date));
		foreignLanguageDao.save((ForeignLanguage)dtoContertService.dtoClassConverter(foreignLanguageAddDto, ForeignLanguage.class));
		return new SuccessResult("Id numaras?? '" + foreignLanguageAddDto.getCvId() + "' olan cv'ye yabanc?? dil eklendi.");
	}

	@Override
	public Result addSchoolInfo(SchoolInfoAddDto schoolInfoAddDto) {
		LocalDate date = (LocalDate.now());
		schoolInfoAddDto.setCreatedDate(Date.valueOf(date));
		schoolInfoDao.save((SchoolInfo)dtoContertService.dtoClassConverter(schoolInfoAddDto, SchoolInfo.class));
		return new SuccessResult("Id numaras?? '" + schoolInfoAddDto.getCvId() + "' olan cv'ye okul bilgisi eklendi.");
	}

	@Override
	public Result addTechnology(TechnologyAddDto technologyAddDto) {
		LocalDate date = (LocalDate.now());
		technologyAddDto.setCreatedDate(Date.valueOf(date));
		technologyDao.save((Technology)dtoContertService.dtoClassConverter(technologyAddDto, Technology.class));
		return new SuccessResult("Id numaras?? '" + technologyAddDto.getCvId() + "' olan cv'ye teknoloji bilgisi eklendi.");
	}

	@SuppressWarnings("unchecked")
	@Override
	public Result savePhoto(MultipartFile file, int resumeId) {
		Map<String, String> result = (Map<String, String>)cloudinaryService.save(file).getData();
		String photoUrl = result.get("url");
		resumeDao.getOne(resumeId).setPhoto(photoUrl);
		resumeDao.save(resumeDao.getOne(resumeId));
		return new SuccessResult("Resim ba??ar??yla kaydedildi.");
	}

}
