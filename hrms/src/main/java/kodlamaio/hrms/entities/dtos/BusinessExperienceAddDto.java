package kodlamaio.hrms.entities.dtos;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessExperienceAddDto {

	@JsonIgnore
	private int id;
	private int cvId;
	private String businessName;
	private String businessPosition;
	private Date yearOfStart;
	private Date yearOfEnd;
	@JsonIgnore
	private Date createdDate;
}
