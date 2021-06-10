package kodlamaio.hrms.entities.dtos;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForeignLanguageAddDto {

	@JsonIgnore
	private int id;
	private int cvId;
	private String languageName;
	private char languageLevel;
	@JsonIgnore
	private Date createdDate;
}
