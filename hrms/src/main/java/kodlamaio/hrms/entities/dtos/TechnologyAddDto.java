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
public class TechnologyAddDto {

	@JsonIgnore
	private int id;
	private int cvId;
	@NotNull(message = "İsim alanı boş bırakılamaz.")
	private String technologyName;
	@JsonIgnore
	private Date createdDate;
}
