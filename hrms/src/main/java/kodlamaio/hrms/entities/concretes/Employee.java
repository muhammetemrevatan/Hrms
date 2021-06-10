package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
@PrimaryKeyJoinColumn(name = "id")
public class Employee extends User{
	
	@NotBlank(message = "İsim alanı boş bırakılamaz.")
	@Size(min = 3, message = "İsim alanı 3 karakterden az olamaz.")
	@Column(name = "first_name")
	private String firstName;
	
	@NotBlank(message = "Soyisim alanı boş bırakılamaz.")
	@Size(min = 3, message = "Soyisim alanı 3 karakterden az olamaz.")
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "is_activated")
	@JsonIgnore
	private boolean isActivated;

}
