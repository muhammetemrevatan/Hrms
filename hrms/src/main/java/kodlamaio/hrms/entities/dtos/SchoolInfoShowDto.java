package kodlamaio.hrms.entities.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolInfoShowDto {

	private int id;
	private String schoolName;
	private String degreeDegreeName;
	private String department;
	private Date yearOfStart;
	private Date yearOfEnd;
}
