package kodlamaio.hrms.entities.dtos;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeShowDto {
	
	private int id;
	private String candidateFirstName;
	private String candidateLastName;
	private String candidateBirthDate;
	private String photo;
	private String githubLink;
	private String linkedinLink;
	private String coverLatter;
	private Date createdDate;
	private Date lastUpdateDate;
	private List<BusinessExperienceShowDto> businessExperiences;
	private List<ForeignLanguageShowDto> foreignLanguages;
	private List<TechnologyShowDto> technologies;
	private List<SchoolInfoShowDto> schoolInfos;
	
}
