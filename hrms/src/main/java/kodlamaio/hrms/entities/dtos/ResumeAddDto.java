package kodlamaio.hrms.entities.dtos;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeAddDto {
	
	@JsonIgnore
	private int id;
	private int candidateId;
	@JsonIgnore
	private String photo;
	private String githubLink;
	private String linkedinLink;
	private String coverLatter;
	@JsonIgnore
	private Date createdDate;
	@JsonIgnore
	private Date lastUpdateDate;
}
