package kodlamaio.hrms.entities.dtos;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementAddDto {
	
	@JsonIgnore
	private int id;
	private int employerId;
	private int jobPositionId;
	private int openPositionNumber;
	private int salaryMin;
	private int salaryMax;
	private String deadline;
	@JsonIgnore
	private Date createdDate;
	private int cityId;
	private String jobDescription;
	@JsonIgnore
	private boolean isActive;
	@JsonIgnore
	private boolean employeeConfirm;
	private int wayOfWorkId;
	private int workTypeId;
	
}
