package kodlamaio.hrms.entities.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementShowDto {
	
	private int id;
	private String employerCompanyName;
	private String employerId;
	private String jobPositionPosition;
	private int openPositionNumber;
	private Date createdDate;
	private String deadline;
	private String salaryMax;
	private String salaryMin;
	private String cityCity;
	private String jobDescription;
	private String wayOfWorkName;
	private String workTypeName;
	private boolean employeeConfirm;
	private boolean isActive;
}
