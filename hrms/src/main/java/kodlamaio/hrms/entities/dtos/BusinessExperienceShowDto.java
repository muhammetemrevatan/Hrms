package kodlamaio.hrms.entities.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessExperienceShowDto {
	
	private int id;
	private String businessName;
	private String businessPosition;
	private Date yearOfStart;
	private Date yearOfEnd;
	
}
