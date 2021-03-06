package kodlamaio.hrms.entities.dtos;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolInfoAddDto {

	@JsonIgnore
	private int id;
	private int cvId;
	private String schoolName;
	private int degreeId;
	private String department;
	
	@NotNull(message = "bu alan boş bırakılamaz")
	private Date yearOfStart;
	
	private Date yearOfEnd;
	@JsonIgnore
	private Date createdDate;
}
