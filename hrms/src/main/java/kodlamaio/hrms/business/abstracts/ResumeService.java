package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.BusinessExperienceAddDto;
import kodlamaio.hrms.entities.dtos.ForeignLanguageAddDto;
import kodlamaio.hrms.entities.dtos.ResumeAddDto;
import kodlamaio.hrms.entities.dtos.ResumeShowDto;
import kodlamaio.hrms.entities.dtos.SchoolInfoAddDto;
import kodlamaio.hrms.entities.dtos.TechnologyAddDto;

public interface ResumeService {
	
	DataResult<List<ResumeShowDto>> getAllCandidateCv(Candidate candidate);
	Result addResume(ResumeAddDto resumeAddDto);
	Result addBusinessExperience(BusinessExperienceAddDto businessExperienceAddDto);
	Result addForeignLanguage(ForeignLanguageAddDto foreignLanguageAddDto);
	Result addSchoolInfo(SchoolInfoAddDto schoolInfoAddDto);
	Result addTechnology(TechnologyAddDto technologyAddDto);
	Result savePhoto(MultipartFile file, int resumeId);
	
}
